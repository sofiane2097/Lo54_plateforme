/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.PM;

import antlr.StringUtils;
import static com.sun.faces.facelets.util.Path.context;
import fr.utbm.dao.ClientDao;
import fr.utbm.dao.CourseSessionDao;
import fr.utbm.entities.Client;
import fr.utbm.entities.CourseSession;
import fr.utbm.entities.Location;
import fr.utbm.services.CourseSessionService;
import fr.utbm.services.LocationService;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sofiane
 */
@ManagedBean(name = "CourseSessionMB")
@ViewScoped
public class CourseSessionsMB implements Serializable {

    private List<CourseSession> listCourseSession;
    private List<CourseSession> filtredListCourseSession;
    private List<String> cities;
    private CourseSession courseSession;

    public CourseSession getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }
    private Client client;

    public boolean setSession(long id){
        CourseSessionService courseSessionService = new CourseSessionService();
        CourseSession cs = courseSessionService.getCourseSessionById(id);
        this.courseSession = cs; 
        return true;
    }
    
    public void inscription(long idSession, long idClient){
        ClientDao cdao = new ClientDao();
        CourseSessionDao csDao= new CourseSessionDao();

        Client c1 = cdao.getClientByIdDao(idClient);
        CourseSession cs = csDao.getCourseSessionByIdDao(idSession);
        CourseSession csM = csDao.getCourseSessionByIdDao(idSession);
        csM.getClients().add(c1);
        csDao.updateCourseSessionDao(cs, csM);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Inscriptions succeded"));
        listCourseSession =getAllCourseSessions();
        filtredListCourseSession =getAllCourseSessions();
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<CourseSession> getFiltredListCourseSession() {
        return filtredListCourseSession;
    }

    private List<String> getLocations() {
        LocationService locationService = new LocationService();
        List<String> listLocationsString = new ArrayList<>();
        for (Location location : locationService.getAllCourseSessions()) {
            listLocationsString.add(location.getCity());
        }
        return listLocationsString;
    }

    public void setFiltredListCourseSession(List<CourseSession> filtredListCourseSession) {
        this.filtredListCourseSession = filtredListCourseSession;
    }

    public boolean filterByDateBegins(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.isEmpty()) {
            return true;
        }
        if (value == null) {
            return false;
        }

        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        DateFormat dfValue = new SimpleDateFormat("yyyy-MM-dd");

        String filterDateString = ((Date) value).toString();
        Date dateFrom;
        Date filterDate;
        try {
            String fromPart = filterText;
            dateFrom = fromPart.isEmpty() ? null : df.parse(fromPart);
            filterDate = filterDateString.isEmpty() ? null : dfValue.parse(filterDateString);
        } catch (ParseException pe) {
            return false;
        }

        return (dateFrom == null || filterDate.after(dateFrom));
    }

    public boolean filterByDateEnds(Object value, Object filter, Locale locale) {
        System.out.println("end filter");
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.isEmpty()) {
            return true;
        }
        if (value == null) {
            return false;
        }

        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        DateFormat dfValue = new SimpleDateFormat("yyyy-MM-dd");

        String filterDateString = ((Date) value).toString();
        Date dateTo;
        Date filterDate;
        try {
            System.out.println("1");
            String fromPart = filterText;
            System.out.println("2");

            


            dateTo = fromPart.isEmpty() ? null : df.parse(fromPart);
            System.out.println("4");

            
            filterDate = filterDateString.isEmpty() ? null : dfValue.parse(filterDateString);
                                    System.out.println("6");

            System.out.println("toPart"+dateTo.toString()+"fromPart"+dateTo.toString()+"filterDate"+filterDate.toString());
            System.out.println(filterDate.after(dateTo));
            System.out.println(filterDate.before(dateTo));

        } catch (ParseException pe) {
            return false;
        }

        return (dateTo == null || filterDate.before(dateTo));
    }


    public List<CourseSession> getListCourseSession() {
        return listCourseSession;
    }

    public void setListCourseSession(List<CourseSession> listCourseSession) {
        this.listCourseSession = listCourseSession;
    }

    public CourseSessionsMB(List<CourseSession> listCourseSession, List<CourseSession> filtredListCourseSession) {
        this.listCourseSession = listCourseSession;
        this.filtredListCourseSession = filtredListCourseSession;
    }

    @Override
    public String toString() {
        return "CourseSessionsMB{" + "listCourseSession=" + listCourseSession + ", filtredListCourseSession=" + filtredListCourseSession + '}';
    }

    public CourseSessionsMB() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        this.client = (Client) session.getAttribute("client");
        if (client == null) {
            facesContext.getExternalContext().redirect("login.xhtml");
        }
        this.listCourseSession = getAllCourseSessions();
        this.cities = getLocations();
        
    }

    private List<CourseSession> getAllCourseSessions() {
        CourseSessionService courseSessionService = new CourseSessionService();
        return courseSessionService.getAllCourseSessions();
    }
    
    

}
