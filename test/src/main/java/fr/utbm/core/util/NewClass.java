/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.util;

import fr.utbm.entities.Location;
import org.hibernate.Session;

/**
 *
 * @author kezraidi
 */
public class NewClass {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println(session.isConnected()?"connected":"not connected");
        /*session.beginTransaction();
        Location l = new Location(null, "belfort");
        session.persist(l);
        session.getTransaction().commit();*/
    }
}
