/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entities;

import java.io.Serializable;

/**
 *
 * @author kezraidi
 */
public class CourseSessiono implements Serializable {

    private Long idSession;
    private Long idLocation;
    private String codeCourse;
    private String sessionStart;
    private String sessionEnd;
    private Long sessionMax;

    public CourseSessiono(Long idSession, Long idLocation, String codeCourse, String sessionStart, String sessionEnd, Long sessionMax) {
        this.idSession = idSession;
        this.idLocation = idLocation;
        this.codeCourse = codeCourse;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.sessionMax = sessionMax;
    }

    public CourseSessiono() {
    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public String getCodeCourse() {
        return codeCourse;
    }

    public void setCodeCourse(String codeCourse) {
        this.codeCourse = codeCourse;
    }

    public String getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(String sessionStart) {
        this.sessionStart = sessionStart;
    }

    public String getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(String sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public Long getSessionMax() {
        return sessionMax;
    }

    public void setSessionMax(Long sessionMax) {
        this.sessionMax = sessionMax;
    }
    
}
