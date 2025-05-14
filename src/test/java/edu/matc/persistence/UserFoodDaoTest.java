package com.nutritiontracker.persistence;

import com.nutritiontracker.entity.Food;
import com.nutritiontracker.entity.User;
import com.nutritiontracker.entity.UserFood;
import com.nutritiontracker.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User food dao test.
 */
class UserFoodDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The User dao.
     */
    GenericDao<User> userDao;
    /**
     * The Food dao.
     */
    GenericDao<Food> foodDao;
    /**
     * The User food dao.
     */
    GenericDao<UserFood> userFoodDao;

    UserfoodDao listFoodDao;


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        userFoodDao = new GenericDao<>(UserFood.class);
        foodDao = new GenericDao<>(Food.class);
        userDao = new GenericDao<>(User.class);
        listFoodDao = new UserfoodDao();

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets user food by id.
     */
    @Test
    void getUserFoodById() {
        UserFood retrievedUserFood = userFoodDao.getById(1);
        assertNotNull(retrievedUserFood);
        assertEquals("Chicken Breast", retrievedUserFood.getFoodName());
    }

    /**
     * Update user food.
     */
    @Test
    void updateUserFood() {
        String newFoodName = "Lean Chicken Breast";
        // Get the food from the table
        Food retrievedFood = foodDao.getById(1);

        // Update the name of the food
        retrievedFood.setFoodName(newFoodName);

        // Update the food in the table
        foodDao.update(retrievedFood);

        // Get the food from the table
        UserFood retrievedUserFood = userFoodDao.getById(1);

        // Verify the updated food
        assertNotNull(retrievedUserFood);

        // Since these are two different objects, they won't be equal, but the food names will be
        // Not sure if there is a better way to test equalness of values of a different object.
        assertEquals(retrievedFood.getFoodName(), retrievedUserFood.getFoodName());
    }

    /**
     * Insert user food.
     *
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     */
    @Test
    void insertUserFood() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // get a user, verify user exists
        User user = userDao.getById(1);
        assertNotNull(user);

        // get the food
        Food food = foodDao.getById(1);

        // Create food with that user
        UserFood foodEnteredByUser = new UserFood(user, food, "2025-02-22", 5, "Lunch" );
        int insertedUserFoodId = userFoodDao.insert(foodEnteredByUser);

        // retrieve the food
        UserFood retrievedUserFood = userFoodDao.getById(insertedUserFoodId);

        // Verify not null and the entered food and retrieved food is the same
        assertNotNull(retrievedUserFood);
        assertEquals(foodEnteredByUser, retrievedUserFood);
    }

    /**
     * Delete user food.
     *
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     */
    @Test
    // deletes everything a user tracked
    void deleteUserFood() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // Step 1: Create and insert food entry
        Food food = new Food("Ground Beef", "Meat", 1, "Ounce", 93, 8, 0, 4);
        foodDao.insert(food);
        int foodId = foodDao.getByUsername("foodName", "Ground Beef").getId();

        logger.debug("Created food id (3): " + foodId);

        // Step 2: Create and insert user
        User user = new User("b1db5510-d031-70b0-fe58-bf0ed1039h23", "user", "testUser", "testUser@test.edu", "12-31-1983");
        int userId = userDao.insert(user);

        logger.debug("Created user id (3): " + userId);

        UserFood tracker = new UserFood(user, food, "2025-02-22", 5, "Lunch");
        int trackerId = userFoodDao.insert(tracker);

        logger.debug("Food id in tracker to be deleted: " + trackerId);

        // Check that things are inserted properly
        assertNotNull(userDao.getById(userId));
        assertNotNull(foodDao.getById(foodId));
        assertEquals(4, userFoodDao.getAll().size());
        logger.debug("Number of userFoods in tracker before deletion (4):  " + userFoodDao.getAll().size());

        // Delete user food
        logger.debug("Id of user to be deleted (3): " + userFoodDao.getById(userId).getId());
        logger.debug("Id of user to be deleted (3): " + userFoodDao.getById(userId));

        userFoodDao.deleteEntity(userFoodDao.getById(userId));
        logger.debug("User's Foods in DB " + userFoodDao.getAll().toString());

        // Verify user deletion
        assertNull(userFoodDao.getById(userId));

        // Verify associated food tracker entries are deleted
        assertNull(userFoodDao.getById(userId));

        // Verify food still exists in food table
        assertNotNull(foodDao.getById(foodId));
        assertEquals("Ground Beef", food.getFoodName());
    }

    /**
     * Gets all user food.
     */
    @Test
    void getAllUserFood() {
        List<UserFood> foods = userFoodDao.getAll();
        assertNotNull(foods);
        assertEquals(3, foods.size());
    }

    @Test
    void getMealsByMealType(){
        List<UserFood> retrievedMeals = userFoodDao.getMealsByMealType( "mealTime","lunch");
        retrievedMeals.sort(Comparator.comparing(meal -> LocalDate.parse(meal.getDate())));

        assertNotNull(retrievedMeals);
        assertEquals("2025-02-15", retrievedMeals.get(0).getDate());
    }

    // TODO: Test this method
    @Test
    void listMealsGroupedByMealTypeAndSortedByDate() {
        Map<String, List<UserFood>> meals = listFoodDao.getMealsGroupedByMealTimeSortedByDate(1);

        // TODO: Case sensitive!!!
        List<UserFood> lunchMeals = meals.get("Lunch");
        assertNotNull(lunchMeals);
        assertFalse(lunchMeals.isEmpty());
        assertEquals("2025-02-15", lunchMeals.get(0).getDate());
    }

    @Test
    void getUserFoodDate() {
        UserFood retrievedUserFood = userFoodDao.getById(1);
        String date = retrievedUserFood.getDate();
        assertNotNull(date);
        assertEquals("2025-02-15", date);
    }

    @Test
    @Disabled
    void listMealsByDate() {
        User retrievedUser = userDao.getById(1);

        // get all meals made by the user in food_tracker table
        List<UserFood> usersFoods = retrievedUser.getFoodTracker();

        // organize meals by date
        Map<String, List<UserFood>> mealsByDate = usersFoods.stream().collect(Collectors.groupingBy(UserFood::getDate));

        assertEquals("???", mealsByDate);
    }
}