package edu.matc.persistence;

import edu.matc.entity.Food;
import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    /**
     * Get food item by id
     * @param id id of food
     * @return food
     */
    public Food getFoodById(int id){
        Session session = sessionFactory.openSession();
        Food food = session.get(Food.class, id);
        session.close();
        return food;
    }

    /**
     * Get a list of all foods
     * @return list of foods
     */
    public List<Food> getAllFood(){
        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Food> criteria = builder.createQuery(Food.class);
        Root<Food> root = criteria.from(Food.class);
        List<Food> foods = session.createSelectionQuery(criteria).getResultList();

        logger.debug("The list of foods is " + foods);
        session.close();
        return foods;
    }

    /**
     * Update a food
     * @param food food to be updated
     */
    public void updateFood(Food food){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(food);
        transaction.commit();
        session.close();
    }

    /**
     * Add a new food to food table
     * @param food new food to be added
     * @return id of food added
     */
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

    /**
     * Delete food from table
     * @param food food to be deleted from table
     */
    public void deleteFood(Food food){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(food);
        transaction.commit();
        session.close();
    }
}
