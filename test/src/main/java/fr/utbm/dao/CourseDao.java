/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dao;
import fr.utbm.entities.Course;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author BADELH
 */
public class CourseDao {

    Session session;

    public void insertCourseDao(Course course) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error insert Client");
        }
    }


    public List<Course> getCoursesDao() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Course> client = null;
        Query query = session.createQuery("from COURSE");
        client = query.list();
        return client;

    }

    //// lààààààààààààààààààààààà
    ///// debut modif SOFIANE
    public void updateCourseDao(Course oldCourse, Course newCourse) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            oldCourse.setId(newCourse.getId());
            oldCourse.setTitle(newCourse.getTitle());         
            session.merge(oldCourse);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error update Course");
        }
    }

    public void deleteCourseDao(Long id) {
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        Course customer=(Course)session.get(Course.class, id);
         if(customer!=null){
                session.delete(customer);
            System.out.println("client is deleted");
         }

        }catch(Exception ex){
            System.err.println("error delete client");
            ex.printStackTrace();
        }
    }

}
