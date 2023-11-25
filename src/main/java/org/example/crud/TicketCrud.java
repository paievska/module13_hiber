package org.example.crud;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketCrud implements Crud<Ticket> {
    @Override
    public void persist(Ticket entity) {
        try (HibernateUtil instance = HibernateUtil.getInstance();
             SessionFactory sessionFactory = instance.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
    }

    @Override
    public Ticket getById(Object id) {
        try (HibernateUtil instance = HibernateUtil.getInstance()){
            SessionFactory sessionFactory = instance.getSessionFactory();
            Session session = sessionFactory.openSession();
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public void merge(Ticket entity) {
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
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
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
