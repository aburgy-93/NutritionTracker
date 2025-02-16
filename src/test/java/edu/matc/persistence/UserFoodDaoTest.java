package edu.matc.persistence;

import edu.matc.entity.Food;
import edu.matc.entity.UserFood;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserFoodDaoTest {
    UserFoodDao userFoodDao;
    UserFood userFood;

    @BeforeEach
    void setUp() {
        userFoodDao = new UserFoodDao();
        Database database = new Database();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getUserFoodById() {
        UserFood food = userFoodDao.getUserFoodById(1);
        assertNotNull(food);
        assertEquals(food.getUserId(), 1);
    }

    @Test
    void updateUserFood() {
        UserFood foodToUpdate = userFoodDao.getUserFoodById(1);
        foodToUpdate.setFoodName("Lean Chicken Breast");
        userFoodDao.updateUserFood(foodToUpdate);

        UserFood food = userFoodDao.getUserFoodById(1);
        assertEquals(food.getFoodName(), foodToUpdate.getFoodName());
    }

    @Test
    // How do I calculate the total calories, pro, carbs, fat when entering a new food?
    void insertUserFood() {
        UserFood insertFood = new UserFood(1, "2025-02-16", "Large Egg", "Poultry",
                1, 70, 6.0, 1.0, 4.5, "Breakfast",  70, 6.0, 1.0, 4.5);
        userFoodDao.insertUserFood(insertFood);
        assertNotNull(userFoodDao.getUserFoodById(3));
        assertEquals(userFoodDao.getUserFoodById(3).getFoodName(), insertFood.getFoodName());
    }

    @Test
    void deleteUserFood() {
        UserFood food = userFoodDao.getUserFoodById(1);
        userFoodDao.deleteUserFood(food);
        assertNull(userFoodDao.getUserFoodById(1));
    }

    @Test
    // How to list all foods based on userId?
    void getAllUserFood() {
        List<UserFood> userFoods = userFoodDao.getAllUserFood();
        assertEquals(2, userFoods.size());
    }
}