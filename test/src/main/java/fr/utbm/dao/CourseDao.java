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
    public void updateClientDao(Course oldCourse, Course newCourse) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            oldCourse.setAdresse(newCourse.getAdresse());
            oldCourse.setEmail(newCourse.getEmail());
            oldCourse.setFirstName(newCourse.getFirstName());
            oldCourse.setLastName(newCourse.getLastName());
            oldCourse.setPhone(newCourse.getPhone());
            oldCourse.setPwd(newCourse.getPwd());
            session.merge(oldCourse);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(" Error update client");
        }
    }

    public void deleteClientDao(Long id) {
        try{
        session = HibernateUtil.getSessionFactory().openSession();

       Client customer=(Client) session.get(Client.class, id);
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
