/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.PM;

import fr.utbm.dao.ClientDao;
import fr.utbm.dao.CourseSessionDao;
import fr.utbm.entities.Client;
import fr.utbm.entities.CourseSession;
import fr.utbm.services.ClientService;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sofiane
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginMB implements Serializable {

    private Client client;
    private String message = "Enter username and password.";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginMB{" + "client=" + client + ", message=" + message + '}';
    }

    public LoginMB(Client client) {
        this.client = client;
    }

    
    public void showUser(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Client clientT = (Client) session.getAttribute("client");
        this.message = clientT.toString();
        System.out.println("session client" + clientT);
    }
    
    public void logout() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String login() throws IOException {
        System.out.println("******************");

        FacesContext context = FacesContext.getCurrentInstance();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Client clientT = (Client) session.getAttribute("client");
        System.out.println("session client" + clientT);

        ClientService clientService = new ClientService();
        Client clientLogged = clientService.getLoginClient(client.getEmail(), client.getPwd());
        if (clientLogged != null) {
            context.getExternalContext().getSessionMap().put("client", clientLogged);
            message = "Successfully logged-in.";
            context.getExternalContext().redirect("Courses.xhtml");
            return "success";
        } else {
            context.addMessage(null, new FacesMessage("Authentication Failed. Check email or password."));
            message = "";
            return "login";
        }
    }

    public LoginMB() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        this.client = new Client();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
