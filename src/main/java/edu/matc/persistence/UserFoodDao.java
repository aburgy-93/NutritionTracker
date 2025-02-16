package edu.matc.persistence;

import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.SessionFactory;

import edu.matc.entity.UserFood;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class UserFoodDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get a user entered food
     * @param id id of food to be returned
     * @return food
     */
    public UserFood getUserFoodById(int id) {
        Session session = sessionFactory.openSession();
        UserFood food = session.get(UserFood.class, id);
        session.close();
        return food;
    }

    /**
     * Update a user food item
     * @param food food to be updated
     */
    public void updateUserFood(UserFood food) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(food);
        transaction.commit();
        session.close();
    }

    /**
     * Insert a new food into user's food tracker
     * @param food food to be inserted
     * @return food id
     */
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

    /**
     * Delete food from user tracker
     * @param food food to be deleted
     */
    public void deleteUserFood(UserFood food) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(food);
        transaction.commit();
        session.close();
    }

    /**
     * Get all foods in user food tracker
     * @return list of foods
     */
    public List<UserFood> getAllUserFood() {
        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserFood> criteria = builder.createQuery(UserFood.class);
        Root<UserFood> root = criteria.from(UserFood.class);
        List<UserFood> foods = session.createQuery(criteria).getResultList();

        logger.debug("The list of foods is " + foods);
        session.close();
        return foods;
    }
}
