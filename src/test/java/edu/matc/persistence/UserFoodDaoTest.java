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
        Food retrievedFood = foodDao.getById(1);
        retrievedFood.setFoodName("Lean Chicken Breast");
        foodDao.update(retrievedFood);
        UserFood retrievedUserFood = userFoodDao.getById(1);
        assertNotNull(retrievedUserFood);
        assertEquals("Lean Chicken Breast", retrievedUserFood.getFoodName());
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
        // get a user
        User user = userDao.getById(1);
        assertNotNull(user);

        // Create food with that user
        UserFood foodEnteredByUser = new UserFood(user.getId(), 2, "2025-02-20", 1, "Breakfast", 70, 6.0, 1.0, 4.5, user);
        int insertedUserFoodId = userFoodDao.insert(foodEnteredByUser);

        // retrieve the food
        UserFood retrievedUserFood = userFoodDao.getById(insertedUserFoodId);

        // Verify
        assertNotNull(retrievedUserFood);
        assertEquals("White Rice", retrievedUserFood.getFoodName());
    }

    /**
     * Delete user food.
     */
    @Test
    // deletes everything a user tracked
    void deleteUserFood() {
        userFoodDao.deleteEntity(userFoodDao.getById(2));
        assertNull(userFoodDao.getById(2));
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