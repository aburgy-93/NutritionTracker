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
     * Get food by id user entered
     */
    public UserFood getUserFoodById(int id) {
        Session session = sessionFactory.openSession();
        UserFood food = session.get(UserFood.class, id);
        session.close();
        return food;
    }

    public void updateUserFood(UserFood food) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(food);
        transaction.commit();
        session.close();
    }

    public int insertUserFood(UserFood food, User user) {
        int id = 0;
        int userId = user.getId();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(food);
        transaction.commit();
        id = food.getId();
        session.close();
        return id;
    }

    public void deleteUserFood(UserFood food) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(food);
        transaction.commit();
        session.close();
    }

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
