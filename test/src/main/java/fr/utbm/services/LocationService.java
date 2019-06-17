/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.services;

import fr.utbm.dao.LocationDao;
import fr.utbm.entities.Location;
import java.util.List;

/**
 *
 * @author Sofiane
 */
public class LocationService {
    public List<Location> getAllCourseSessions(){
        LocationDao locationDao = new LocationDao();
        return locationDao.getLocationDao();
    }
}
