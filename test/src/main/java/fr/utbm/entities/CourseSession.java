/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.*;

/**
 *
 * @author Sofiane
 */
@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SESSION_ID")
    private Long id;
    private String sessionStart;
    private String sessionEnd;
    private Long sessionMax;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PARTICIPE",
            joinColumns ={ @JoinColumn(name = "SESSION_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CLI_ID")}
    )
    private Set<Client> clients;

    @ManyToOne
    @JoinColumn(name="CRS_ID", nullable=false)
    private Course course;
 
    @ManyToOne
    @JoinColumn(name="LOC_ID", nullable=false)
    private Location location;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public CourseSession() {
    }

    public CourseSession(Long id, String sessionStart, String sessionEnd, Long sessionMax, Set<Client> clients, Course course, Location location) {
        this.id = id;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.sessionMax = sessionMax;
        this.clients = clients;
        this.course = course;
        this.location = location;
    }

   

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    
    
    public CourseSession(Long id, String sessionStart, String sessionEnd, Long sessionMax) {
        this.id = id;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.sessionMax = sessionMax;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof CourseSession)) {
            return false;
        }
        CourseSession other = (CourseSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", sessionStart=" + sessionStart + ", sessionEnd=" + sessionEnd + ", sessionMax=" + sessionMax + ", clients=" + clients + ", course=" + course + ", location=" + location + '}';
    }

  
}
