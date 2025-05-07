package edu.matc.persistence;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.persistence.NoResultException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    public T getBySub(String propertyName, String sub) {
        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + sub);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> property = root.get(propertyName);

        query.where(builder.equal(property, sub ));
        T user = null;

        try {
            user = session.createQuery(query).getSingleResult();
            logger.debug("Found user: " + user);
        } catch (NoResultException e) {
            logger.debug("User not found: " +  e);
        } finally {
            session.close();
        }
        return user;
    }

    public T getByUsername(String propertyName, String value){
        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> property = root.get(propertyName);

        query.where(builder.like(property, "%" + value + "%"));
        T user = session.createQuery(query).getSingleResult();

        session.close();
        return user;
    }

    /**
     * Update.
     *
     * @param entity the entity
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Insert int.
     *
     * @param entity the entity
     * @return the int
     * @throws NoSuchMethodException     the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     */
// ask about this method and retrieving the id of the inserted object
    public int insert(T entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();

        // this id
        id = (int) entity.getClass().getMethod("getId").invoke(entity);
        session.close();
        return id;
    }

    /**
     * Delete entity.
     *
     * @param entity the entity
     */
    public void deleteEntity(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        Session session = getSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createSelectionQuery( query ).getResultList();

//        logger.debug("The list of " + list);
        session.close();

        return list;
    }

    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

//        logger.debug("Searching for order with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> property = root.get(propertyName);

        query.where(builder.like(property, "%" + value + "%"));
        List<T> list = session.createQuery(query).getResultList();

        session.close();
        return list;
    }

    /**
     * Return a list of all meals by a user and their dates
     *
     * @param propertyName the property name
     * @param mealType     the meal type
     * @return the meals by meal type
     */
    public List<T> getMealsByMealType(String propertyName, String mealType) {
        Session session = getSession();
//        logger.debug("Searching for meals with " + propertyName + " = " + mealType);
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.where(builder.equal(root.get(propertyName), mealType));
        List<T> list = session.createQuery(query).getResultList();

        session.close();
        return list;
    }
}
