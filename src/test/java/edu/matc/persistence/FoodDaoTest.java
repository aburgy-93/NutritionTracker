package edu.matc.persistence;

import edu.matc.entity.Food;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FoodDaoTest {
    GenericDao genericDao;

    @BeforeEach

    void setUp() {
        genericDao = new GenericDao(Food.class);
        Database database = new Database();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getFoodById() {
        Food retrievedFood = (Food) genericDao.getById(1);
        assertNotNull(retrievedFood);
        assertEquals("Chicken Breast", retrievedFood.getFoodName());
    }

    @Test
    void getAllFood() {
        List retrievedFood = genericDao.getAll();
        assertNotNull(retrievedFood);
        assertEquals(2, retrievedFood.size());
    }

    @Test
    void updateFood() {
        Food foodToUpdate = (Food) genericDao.getById(1);
        foodToUpdate.setFoodName("Brown Rice");
        genericDao.update(foodToUpdate);
        Food retrievedFood = (Food) genericDao.getById(1);
        assertEquals("Brown Rice", retrievedFood.getFoodName());
    }

    @Test
    void insertFood() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Food foodToInsert = new Food("Large Eggs", "Poultry", 1, "Large Egg",
                70, 4.5,1.0,6.0);
        int insertedFood = genericDao.insert(foodToInsert);
        assertEquals("Large Eggs", foodToInsert.getFoodName());
    }

    @Test
    void deleteFood() {
        Food foodToDelete = (Food) genericDao.getById(2);
        genericDao.deleteEntity(foodToDelete);
        assertNull(genericDao.getById(2));
    }
}