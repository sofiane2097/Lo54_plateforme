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
@Table(name = "LOCATION")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOC_ID")    
    private Long id;
    private String city;

    public Location(Long id, String city, Set<CourseSession> sessions) {
        this.id = id;
        this.city = city;
        this.sessions = sessions;
    }

    public Set<CourseSession> getSessions() {
        return sessions;
    }

    public void setSessions(Set<CourseSession> sessions) {
        this.sessions = sessions;
    }
    
    @OneToMany(mappedBy="location")
    private Set<CourseSession> sessions;
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location(Long id, String city) {
        this.id = id;
        this.city = city;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", city=" + city + ", sessions=" + sessions + '}';
    }

    

}
