package com.nutritiontracker.persistence;

import com.nutritiontracker.entity.Food;
import com.nutritiontracker.entity.User;
import com.nutritiontracker.entity.UserFood;
import com.nutritiontracker.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class UserDaoTest {
    /**
     * The Generic dao.
     */
    GenericDao<User> genericUserDao;
    /**
     * The Generic user food dao.
     */
    GenericDao<UserFood> genericUserFoodDao;
    /**
     * The Generic food dao.
     */
    GenericDao<Food> genericFoodDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        genericUserDao = new GenericDao<>(User.class);
        genericUserFoodDao = new GenericDao<>(UserFood.class);
        genericFoodDao = new GenericDao<>(Food.class);
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets user by username.
     */
    @Test
    void getUserByUsername() {
        User retrievedUser = genericUserDao.getByUsername("username", "aburgy");
        assertNotNull(retrievedUser);
        assertEquals("aburgy", retrievedUser.getUsername());
    }

    /**
     * Update user.
     */
    @Test
    void updateUser() {
        String username = "rbandy";

        // Get the user to update
        User userToUpdate = genericUserDao.getByUsername("username", "rbobandy");

        // Set their new last name
        userToUpdate.setUsername(username);

        // Update the table
        genericUserDao.update(userToUpdate);

        // Retrieve the user from the table
        User retrievedUser = genericUserDao.getByUsername("username", "rbandy");

        // Verify
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Add user.
     *
     * @throws InvocationTargetException the invocation target exception
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     */
    @Test
    void addUser() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // Create new user
        User newUser = new User("b1db5510-d031-70b0-fe58-bf0ed1039f23", "user", "testUser", "testUser@test.edu", "12-31-1983");

        // Insert the new user and return their userId
        int userId = genericUserDao.insert(newUser);

        // Retrieve the new user from the table
        User retrievedUser = genericUserDao.getById(userId);

        // Verify the new user and their data
        assertNotEquals(0, retrievedUser.getId());
        assertEquals(newUser, retrievedUser);
    }

    /**
     * Delete user.
     */
    @Test
    void deleteUser() {
        genericUserDao.deleteEntity(genericUserDao.getById(2));
        assertNull(genericUserDao.getById(2));
    }

    /**
     * Delete a user and their meals.
     */
    @Test
    void deleteWithMeals() {
        // get the user we want to delete that has food associated with it
        User userToDelete = genericUserDao.getById(1);
        assertNotNull(userToDelete);

        // Get all foods a user has entered
        List<Food> foodsToDelete = genericFoodDao.getAll();
        assertNotNull(foodsToDelete);

        // get the associated food IDs
        int food1 = foodsToDelete.get(0).getId();
        int food2 = foodsToDelete.get(1).getId();

        // verify user was deleted
        genericUserDao.deleteEntity(userToDelete);
        assertNull(genericUserDao.getById(1));

        // verify the foods were deleted
        assertNull(genericUserFoodDao.getById(food1));
        assertNull(genericUserFoodDao.getById(food2));
    }

    /**
     * Gets all users.
     */
    @Test
    void getAllUsers() {
        List<User> users = genericUserDao.getAll();
        assertEquals(2, users.size());
    }
}