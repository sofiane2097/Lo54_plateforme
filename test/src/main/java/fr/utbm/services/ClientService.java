/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.services;

import fr.utbm.dao.ClientDao;
import fr.utbm.entities.Client;

/**
 *
 * @author Sofiane
 */
public class ClientService {
     public Client getLoginClient(String email, String pwd){
         ClientDao clientDao = new ClientDao();
        return clientDao.getClientLoginDao(email, pwd);
    }
}
