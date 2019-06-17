/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.services;

import fr.utbm.dao.CourseSessionDao;
import fr.utbm.entities.CourseSession;
import java.util.List;

/**
 *
 * @author Sofiane
 */

public class CourseSessionService {
    
    public List<CourseSession> getAllCourseSessions(){
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        return courseSessionDao.getCourseSessionDao();
    }
    
    public CourseSession getCourseSessionById(long id){
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        return courseSessionDao.getCourseSessionByIdDao(id);
    }
    
    
}
