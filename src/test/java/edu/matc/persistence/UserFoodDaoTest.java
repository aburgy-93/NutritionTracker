package edu.matc.persistence;

import edu.matc.entity.Food;
import edu.matc.entity.User;
import edu.matc.entity.UserFood;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserFoodDaoTest {
    UserFoodDao userFoodDao;
    FoodDao foodDao;
    UserDao userDao;

    @BeforeEach
    void setUp() {
        userFoodDao = new UserFoodDao();
        foodDao = new FoodDao();
        userDao = new UserDao();
        Database database = new Database();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getUserFoodById() {
        UserFood retrievedUserFood = userFoodDao.getUserFoodById(1);
        assertNotNull(retrievedUserFood);
        assertEquals("Chicken Breast", retrievedUserFood.getFoodName());
    }

    @Test
    void updateUserFood() {
        Food retrievedFood = foodDao.getFoodById(1);
        retrievedFood.setFoodName("Lean Chicken Breast");
        foodDao.updateFood(retrievedFood);
        UserFood retrievedUserFood = userFoodDao.getUserFoodById(1);
        assertNotNull(retrievedUserFood);
        assertEquals("Lean Chicken Breast", retrievedUserFood.getFoodName());
    }

    @Test
    void insertUserFood() {
        // get a user
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(1);
        assertNotNull(user);

        // Create food with that user
        UserFood foodEnteredByUser = new UserFood(user.getId(), 2, "2025-02-20", 1, "Breakfast", 70, 6.0, 1.0, 4.5, user);
        int insertedUserFoodId = userFoodDao.insertUserFood(foodEnteredByUser);

        // retrieve the food
        UserFood retrievedUserFood = userFoodDao.getUserFoodById(insertedUserFoodId);

        // Verify
        assertNotNull(retrievedUserFood);
        assertEquals("White Rice", retrievedUserFood.getFoodName());

    }

    @Test
    // deletes everything a user tracked
    void deleteUserFood() {
        userFoodDao.deleteUserFood(userFoodDao.getUserFoodById(2));
        assertNull(userFoodDao.getUserFoodById(2));
    }

    @Test
    void getAllUserFood() {
        List<UserFood> foods = userFoodDao.getAllUserFood();
        assertNotNull(foods);
        assertEquals(2, foods.size());
    }
}