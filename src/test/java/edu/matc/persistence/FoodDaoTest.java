package edu.matc.persistence;

import edu.matc.entity.Food;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Food dao test.
 */
class FoodDaoTest {
    /**
     * The Generic dao.
     */
    GenericDao<Food> genericDao;

    /**
     * Sets up.
     */
    @BeforeEach

    void setUp() {
        genericDao = new GenericDao<>(Food.class);
        Database database = new Database();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets food by id.
     */
    @Test
    void getFoodById() {
        Food retrievedFood = genericDao.getById(1);
        assertNotNull(retrievedFood);
        assertEquals("Chicken Breast", retrievedFood.getFoodName());
    }

    /**
     * Gets all food.
     */
    @Test
    void getAllFood() {
        List<Food> retrievedFood = genericDao.getAll();
        assertNotNull(retrievedFood);
        assertEquals(2, retrievedFood.size());
    }

    /**
     * Update food.
     */
    @Test
    void updateFood() {
        Food foodToUpdate = genericDao.getById(1);
        foodToUpdate.setFoodName("Brown Rice");
        genericDao.update(foodToUpdate);
        Food retrievedFood = genericDao.getById(1);
        assertEquals("Brown Rice", retrievedFood.getFoodName());
    }

    /**
     * Insert food.
     *
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     */
    @Test
    void insertFood() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Food foodToInsert = new Food("Large Eggs", "Poultry", 1, "Large Egg",
                70, 4.5,1.0,6.0);
        genericDao.insert(foodToInsert);

        assertEquals("Large Eggs", foodToInsert.getFoodName());
    }

    /**
     * Delete food.
     */
    @Test
    void deleteFood() {
        Food foodToDelete = genericDao.getById(2);
        genericDao.deleteEntity(foodToDelete);
        assertNull(genericDao.getById(2));
    }
}