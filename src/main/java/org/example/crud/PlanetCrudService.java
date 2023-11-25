package org.example.crud;

import org.example.entities.Planet;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetCrudService implements Crud<Planet> {
    @Override
    public void persist(Planet entity) {
        try (HibernateUtil instance = HibernateUtil.getInstance();
             SessionFactory sessionFactory = instance.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public Planet getById(Object id) {
        try (HibernateUtil instance = HibernateUtil.getInstance()){
             SessionFactory sessionFactory = instance.getSessionFactory();
             Session session = sessionFactory.openSession();
            return session.get(Planet.class, id);
        }
    }

    @Override
    public void merge(Planet entity) {
        try (HibernateUtil instance = HibernateUtil.getInstance();
             SessionFactory sessionFactory = instance.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        try (HibernateUtil instance = HibernateUtil.getInstance();
             SessionFactory sessionFactory = instance.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
