/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dao;

import fr.utbm.entities.CourseSession;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sofiane a verifier par khalid
 */
public class CourseSessionDao {

    Session session;

    public void insertCourseSessionDao(CourseSession courseSession) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(courseSession);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error insert courseSession");
        }

    }

    public List<CourseSession> getCourseSessionDao() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> courseSession = null;
        Query query = session.createQuery("from CourseSession");
        courseSession = query.list();
        return courseSession;

    }

     public CourseSession getCourseSessionByIdDao(long id) {
        CourseSession courseSession = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CourseSession where SESSION_ID = :id");
        query.setParameter("id", id);
        courseSession = (CourseSession) query.uniqueResult();
        return courseSession;
    }
    
    public void updateCourseSessionDao(CourseSession oldCourseSession, CourseSession newCourseSession) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            oldCourseSession.setId(newCourseSession.getId());
            oldCourseSession.setClients(newCourseSession.getClients());
            oldCourseSession.setLocation(newCourseSession.getLocation());
            oldCourseSession.setCourse(newCourseSession.getCourse());
            oldCourseSession.setSessionStart(newCourseSession.getSessionStart());
            oldCourseSession.setSessionEnd(newCourseSession.getSessionEnd());
            oldCourseSession.setSessionMax(newCourseSession.getSessionMax());
            session.merge(oldCourseSession);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error update courseSession");
        }
    }

    public void deleteCourseSessionDao(Long id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CourseSession courseSession = (CourseSession) session.get(CourseSession.class, id);
            if (courseSession != null) {
                session.delete(courseSession);
                System.out.println("courseSession is deleted");
            }

        } catch (Exception ex) {
            System.err.println("error delete courseSession");
            ex.printStackTrace();
        }
    }

}
