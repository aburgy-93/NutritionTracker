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
        // get food by its ID
        Food retrievedFood = genericDao.getById(1);

        // verify it exists
        assertNotNull(retrievedFood);
        assertEquals("Chicken Breast", retrievedFood.getFoodName());
    }

    /**
     * Gets all food.
     */
    @Test
    void getAllFood() {
        // get all foods in the food table
        List<Food> retrievedFood = genericDao.getAll();

        // get the size of the table
        int tableSize = retrievedFood.size();

        // verify the size of the list
        assertNotNull(retrievedFood);
        assertEquals(tableSize, retrievedFood.size());
    }

    /**
     * Update food.
     */
    @Test
    void updateFood() {
        // String with updated food name
        String updatedFoodName = "Brown rice";

        // get food to update
        Food foodToUpdate = genericDao.getById(1);

        // set the food's new name
        foodToUpdate.setFoodName(updatedFoodName);

        // update the food
        genericDao.update(foodToUpdate);

        // get the food inserted by id
        Food retrievedFood = genericDao.getById(1);

        // verify the updated food and retrieved food are the same
        assertEquals(foodToUpdate, retrievedFood);
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
        // create food to be inserted
        Food foodToInsert = new Food("Large Eggs", "Poultry", 1, "Large Egg",
                70, 4.5,1.0,6.0);

        // insert the food
        genericDao.insert(foodToInsert);

        // get food inserted
        Food retrievedFood = genericDao.getById(3);

        // check to make sure the inserted food and food in table are the same
        assertEquals(retrievedFood, foodToInsert);
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

    /**
     * Gets by property like.
     */
    @Test
    void getByPropertyLike() {
        List<Food> foods = genericDao.getByPropertyLike("foodName", "Chicken");

        assertEquals(1, foods.size());
    }
}