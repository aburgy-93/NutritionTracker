package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao;
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDao();
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
        User userToUpdate = userDao.getUserById(1);
        userToUpdate.setLastName("Smith");
        userDao.updateUser(userToUpdate);
    }

    @Test
    void addUser() {
        User newUser = new User("user", "Ricky", "Bobby", "numberone@gmail.com", 225, "1979-01-01");
        userDao.addUser(newUser);
        assertNotEquals(0, newUser.getId());
        assertEquals("Ricky", userDao.getUserById(newUser.getId()).getFirstName());
    }

    @Test
    void deleteUser() {
        genericDao.deleteEntity(userDao.getUserById(1));
        assertNull(userDao.getUserById(1));
    }

    @Test
    void getAllUsers() {
        List users = genericDao.getAll();
        assertEquals(1, users.size());
    }
}