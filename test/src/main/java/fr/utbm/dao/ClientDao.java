/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dao;

import fr.utbm.entities.Client;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDao {

    Session session;

    public void insertClientDao(Client client) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error insert Client");
        }
    }

    public Client getClientLoginDao(String email, String pwd) {
        Client client = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Client where EMAIL = :email and PWD= :pwd  ");
        query.setParameter("email", email);
        query.setParameter("pwd", pwd);
        client = (Client) query.uniqueResult();
        return client;
    }
    public Client getClientByIdDao(long id) {
        Client client = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Client where CLI_ID= :id  ");
        query.setParameter("id", id);
        client = (Client) query.uniqueResult();
        return client;
    }

    public List<Client> getClientsDao() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List<Client> client = null;
            Query query = session.createQuery("from Client ");
            client = query.list();
            return client;
        } catch (Exception e) {
            throw e;

        }

    }

    public void updateClientDao(Client oldClient, Client newClient) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            oldClient.setAdresse(newClient.getAdresse());
            oldClient.setEmail(newClient.getEmail());
            oldClient.setFirstName(newClient.getFirstName());
            oldClient.setLastName(newClient.getLastName());
            oldClient.setPhone(newClient.getPhone());
            oldClient.setPwd(newClient.getPwd());
            session.merge(oldClient);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error update client");
        }
    }

    public void deleteClientDao(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Client customer = (Client) session.get(Client.class, id);
            if (customer != null) {
                Transaction tx = session.beginTransaction();
                session.delete(customer);
                tx.commit();
                System.out.println("client is deleted");
            }

        } catch (Exception ex) {
            System.err.println("error delete client");
            ex.printStackTrace();
        }
    }

}
