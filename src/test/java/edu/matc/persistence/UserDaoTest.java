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
        Database database = new Database();
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets user by id.
     */
    @Test
    void getUserById() {
        User retrievedUser = genericUserDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Alex", retrievedUser.getFirstName());
    }

    /**
     * Update user.
     */
    @Test
    void updateUser() {
        User userToUpdate = genericUserDao.getById(1);
        userToUpdate.setLastName("Smith");
        genericUserDao.update(userToUpdate);
        User retrievedUser = genericUserDao.getById(1);
        assertEquals("Smith", retrievedUser.getLastName());
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
        User newUser = new User("user", "Ricky", "Bobby", "numberone@gmail.com", 225, "1979-01-01");

        int userId = genericUserDao.insert(newUser);

        User retrievedUser = genericUserDao.getById(userId);

        assertNotEquals(0, retrievedUser.getId());
        assertEquals("Ricky", retrievedUser.getFirstName());
    }

    /**
     * Delete user.
     */
    @Test
    void deleteUser() {
        genericUserDao.deleteEntity(genericUserDao.getById(1));
        assertNull(genericUserDao.getById(1));
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
        assertEquals(1, users.size());
    }
}