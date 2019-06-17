/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dao;

import fr.utbm.entities.Location;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sofiane
 */
public class LocationDao 
{
        Session session;
        
        public void insertLocationDao(Location location) 
        {
            session = HibernateUtil.getSessionFactory().openSession();
            try 
            {
                session.beginTransaction();
                session.persist(location);
                session.getTransaction().commit();
            } catch (Exception ex) 
            {
                System.err.println(" Error insert location");
            }
        
        }
        
        public List<Location> getLocationDao() 
        {
            session = HibernateUtil.getSessionFactory().openSession();
            List<Location> location = null;
            Query query = session.createQuery("from Location");
            location = query.list();
            return location;

        }
        public void updateLocationDao(Location oldLocation, Location newLocation) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            oldLocation.setId(newLocation.getId());
            oldLocation.setCity(newLocation.getCity());         
            session.merge(oldLocation);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error update location");
        }
    }

    public void deleteLocationDao(Long id) {
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        Location location=(Location)session.get(Location.class, id);
         if(location!=null){
                session.delete(location);
            System.out.println("location is deleted");
         }

        }catch(Exception ex){
            System.err.println("error delete location");
            ex.printStackTrace();
        }
    }

}
