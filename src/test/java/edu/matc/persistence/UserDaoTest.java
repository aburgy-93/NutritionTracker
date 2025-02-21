package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);
        Database database = new Database();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getUserById() {
        User retrievedUser = (User)genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Alex", retrievedUser.getFirstName());
    }

    @Test
    void updateUser() {
        User userToUpdate = (User)genericDao.getById(1);
        userToUpdate.setLastName("Smith");
        genericDao.update(userToUpdate);
        User retrievedUser = (User)genericDao.getById(1);
        assertEquals("Smith", retrievedUser.getLastName());
    }

    @Test
    void addUser() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        User newUser = new User("user", "Ricky", "Bobby", "numberone@gmail.com", 225, "1979-01-01");

        int userId = genericDao.insert(newUser);

        User retrievedUser = (User)genericDao.getById(userId);

        assertNotEquals(0, retrievedUser.getId());
        assertEquals("Ricky", retrievedUser.getFirstName());
    }

    @Test
    void deleteUser() {
        genericDao.deleteEntity(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }

    @Test
    void getAllUsers() {
        List users = genericDao.getAll();
        assertEquals(1, users.size());
    }
}