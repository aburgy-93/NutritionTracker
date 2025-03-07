package edu.matc.persistence;

import edu.matc.entity.Food;
import edu.matc.entity.User;
import edu.matc.entity.UserFood;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User food dao test.
 */
class UserFoodDaoTest {
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


    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        userFoodDao = new GenericDao<>(UserFood.class);
        foodDao = new GenericDao<>(Food.class);
        userDao = new GenericDao<>(User.class);

        Database database = new Database();
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
        int foodId = foodDao.getById(1).getId();

        // Step 2: Create and insert user
        User user = new User("user", "Jim", "Bobert", "email@email.com", 185, "1993-05-22");
        int userId = userDao.insert(user);

        UserFood tracker = new UserFood(user, food, "2025-02-22", 5, "Lunch");
        int trackerId = userFoodDao.insert(tracker);

        // Check that things are inserted properly
        assertNotNull(userDao.getById(userId));
        assertNotNull(foodDao.getById(foodId));
        assertEquals(3, userFoodDao.getAll().size());

        // Delete user
        userFoodDao.deleteEntity(userFoodDao.getById(userId));

        // Verify user deletion
        assertNull(userFoodDao.getById(userId));

        // Verify associated food tracker entries are deleted
        assertNull(userFoodDao.getById(userId));

        // Verify food still exists in food table
        assertNotNull(foodDao.getById(trackerId));
        assertEquals("Ground Beef", food.getFoodName());
    }

    /**
     * Gets all user food.
     */
    @Test
    void getAllUserFood() {
        List<UserFood> foods = userFoodDao.getAll();
        assertNotNull(foods);
        assertEquals(2, foods.size());
    }
}