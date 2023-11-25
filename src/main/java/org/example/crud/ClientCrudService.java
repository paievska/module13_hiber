package org.example.crud;

import org.example.entities.Client;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientCrudService implements Crud<Client> {
    @Override
    public void persist(Client entity) {
        try (HibernateUtil instance = HibernateUtil.getInstance();
             SessionFactory sessionFactory = instance.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public Client getById(Object id) {
        try (HibernateUtil instance = HibernateUtil.getInstance();
            SessionFactory sessionFactory = instance.getSessionFactory();
            Session session = sessionFactory.openSession()){
            return session.get(Client.class, id);
        }
    }

    @Override
    public void merge(Client entity) {
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
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.delete(client);
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
