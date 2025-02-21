package edu.matc.persistence;

import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    public T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();
    }

    public int insert(T entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        id = (int) entity.getClass().getMethod("getId").invoke(entity);
        session.close();
        return id;
    }

    public void deleteEntity(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public List<T> getAll() {
        Session session = getSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createSelectionQuery( query ).getResultList();

        logger.debug("The lis of users " + list);
        session.close();

        return list;
    }
}
