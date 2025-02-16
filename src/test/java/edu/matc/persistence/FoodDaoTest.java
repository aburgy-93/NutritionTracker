package edu.matc.persistence;

import edu.matc.entity.Food;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodDaoTest {
    FoodDao foodDao;


    @BeforeEach

    void setUp() {
        foodDao = new FoodDao();
        Database database = new Database();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getFoodById() {
        Food retrievedFood = foodDao.getFoodById(1);
        assertNotNull(retrievedFood);
        assertEquals("Chicken Breast", retrievedFood.getFoodName());
    }

    @Test
    void getAllFood() {
        List<Food> retrievedFood = foodDao.getAllFood();
        assertNotNull(retrievedFood);
        assertEquals(2, retrievedFood.size());
    }

    @Test
    void updateFood() {
        Food foodToUpdate = foodDao.getFoodById(2);
        foodToUpdate.setFoodName("Brown Rice");
        foodDao.updateFood(foodToUpdate);

        Food retrievedFood = foodDao.getFoodById(2);
        assertEquals("Brown Rice", retrievedFood.getFoodName());
    }

    @Test
    void insertFood() {
        Food foodToInsert = new Food("Large Eggs", "Poultry", 1, "Large Egg",
                70, 4.5,1.0,6.0);
        foodDao.insertFood(foodToInsert);
        assertEquals("Large Eggs", foodToInsert.getFoodName());
    }

    @Test
    void deleteFood() {
        Food foodToDelete = foodDao.getFoodById(2);
        foodDao.deleteFood(foodToDelete);
        assertNull(foodDao.getFoodById(2));
    }
}