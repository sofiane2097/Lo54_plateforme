/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Sofiane
 */
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CRS_ID")    
    private String id;
    private String title;

    @OneToMany(mappedBy="course")
    private Set<CourseSession> sessions;

    public Course(String id, String title, Set<CourseSession> sessions) {
        this.id = id;
        this.title = title;
        this.sessions = sessions;
    }

    public Set<CourseSession> getSessions() {
        return sessions;
    }

    public void setSessions(Set<CourseSession> sessions) {
        this.sessions = sessions;
    }
    
    public Course() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", sessions=" + sessions + '}';
    }

}
