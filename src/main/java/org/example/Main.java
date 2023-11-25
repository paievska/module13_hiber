package org.example;

import org.example.crud.*;
import org.example.entities.Client;
import org.example.utils.FlywayMigration;
import org.example.utils.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        try(HibernateUtil instance = HibernateUtil.getInstance();
        SessionFactory sessionFactory = instance.getSessionFactory()){
            FlywayMigration.flywayMigration();
            ClientCrud clientCrud = new ClientCrud();

            Client newClient = new Client();
            newClient.setName("Mary Key");
            clientCrud.persist(newClient);
            System.out.println("Add new client");

            Client client = clientCrud.getById(10);

            client.setName("Jane Ostin");
            clientCrud.merge(client);
            System.out.println("Replace name");
            clientCrud.remove(client.getId());
            System.out.println("Remove client by id");
        }
    }
}