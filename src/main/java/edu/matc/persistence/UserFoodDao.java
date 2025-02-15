package edu.matc.persistence;

import org.hibernate.SessionFactory;

import edu.matc.entity.UserFood;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserFoodDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get food by id user entered
     */
    public UserFood getUserFoodById(int id) {
        Session session = sessionFactory.openSession();
        UserFood food = session.get(UserFood.class, id);
        session.close();
        return food;
    }

    public int insertUserFood(UserFood food) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(food);
        transaction.commit();
        id = food.getId();
        session.close();
        return id;
    }
}
