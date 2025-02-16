package edu.matc.persistence;

import edu.matc.entity.Food;
import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class FoodDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public Food getFoodById(int id){
        Session session = sessionFactory.openSession();
        Food food = session.get(Food.class, id);
        session.close();
        return food;
    }

    public List<Food> getAllFood(){
        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Food> criteria = builder.createQuery(Food.class);
        List<Food> foods = session.createSelectionQuery(criteria).getResultList();

        logger.debug("The list of foods is " + foods);
        session.close();
        return foods;
    }

    public void updateFood(Food food){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(food);
        transaction.commit();
        session.close();
    }

    public int insertFood(Food food){
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(food);
        transaction.commit();
        id = food.getId();
        session.close();
        return id;
    }

    public void deleteFood(Food food){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(food);
        transaction.commit();
        session.close();
    }
}
