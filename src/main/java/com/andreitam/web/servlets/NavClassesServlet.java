package com.andreitam.web.servlets;

import com.andreitam.web.apis.GoogleCalendarService;
import com.andreitam.web.entity.FitnessBooking;
import com.andreitam.web.entity.FitnessClass;
import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.model.DBFitnessBooking;
import com.andreitam.web.model.DBFitnessClass;
import com.andreitam.web.service.ClassService;
import com.andreitam.web.service.GoogleUserService;
import com.andreitam.web.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/navclasses"})
public class NavClassesServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. display user email
        Object email = req.getSession().getAttribute("authUserEmail");
        req.setAttribute("userEmail",email);
        //2. check if not power user (email in enviorment variable) hide buttons: add, edit and delete
        if (GoogleUserService.getInstance().isPowerUser((String) email)) {
            req.setAttribute("powerUser","");
        }
        else {
            req.setAttribute("powerUser","hidden");
        }
        //3. pagination
        int page = 1;
        int recordsPerPage = 7;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        DBFitnessClass fc = new DBFitnessClass();
        List<FitnessClass> listFitnessClasses = fc.getFitnessClassesPagination(page,recordsPerPage);
        Long noOfRecords = fc.getNoOfRecords();
        int noOfRecordsPerPage = listFitnessClasses.size();
        int noOfPages = (int) Math.ceil(noOfRecords*1.0/recordsPerPage);
        req.setAttribute("fitnessClasses",listFitnessClasses);
        req.setAttribute("noOfPages",noOfPages);
        req.setAttribute("noOfRecords",noOfRecords);
        req.setAttribute("noOfRecordsPerPage",noOfRecordsPerPage);
        req.setAttribute("currentPage",page);
        //4. dispatch
        req.getRequestDispatcher("/jsps/classes.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //initialise objects
        DBFitnessClass dbFitnessClass = new DBFitnessClass();
        DBFitnessBooking dbFitnessBooking = new DBFitnessBooking();
        //cases depending on action
        String action = req.getParameter("action");
        switch(action) {
            case "Add":
                //1. add fitness client
                dbFitnessClass.addFitnessClass(new FitnessClass(req.getParameter("classNameAdd"),
                        Integer.parseInt(req.getParameter("maxPartAdd")),
                        0,
                        LocalDateTime.parse(req.getParameter("startDateTimeAdd"), DateTimeFormatter.ISO_DATE_TIME),
                        LocalDateTime.parse(req.getParameter("stopDateTimeAdd"), DateTimeFormatter.ISO_DATE_TIME),
                        true));
                resp.sendRedirect(req.getContextPath() + "/navclasses");
                break;
            case "Delete":
                //1. get fitness class to be deleted
                FitnessClass fitnessClassDelete = dbFitnessClass.getFitnessClass(UUID.fromString(req.getParameter("idDelete")));
                //2. delete google calendar if bookings have been made
                try {
                    //2.1 get all the bookings belonging to this class
                    List<FitnessBooking> listFitnessBookings = dbFitnessBooking.getBookingsByClass(fitnessClassDelete);
                    //2.2 check if they have an eventId and if yes delete the calendar events
                    for (FitnessBooking fBooking: listFitnessBookings) {
                        String eventId = fBooking.getEventId();
                        if (!eventId.isEmpty()) {
                            // Use access token to call Calendar API
                            GoogleCredential credential = new GoogleCredential().setAccessToken((String) req.getSession().getAttribute("accessToken"));
                            //create google calendar service
                            GoogleCalendarService googleCalendarService = new GoogleCalendarService(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential, "FitnessBooking");
                            //create calendar event object from eventId
                            Event event = googleCalendarService.getEvent(eventId);
                            //delete event
                            googleCalendarService.deleteGoogleCalendarEvent(event);
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                //3. delete the bookings for this class
                dbFitnessBooking.deleteFitnessBookingsByClass(fitnessClassDelete);
                //4. delete the class
                dbFitnessClass.deleteFitnessClass(UUID.fromString(req.getParameter("idDelete")));
                //5. redirect
                resp.sendRedirect(req.getContextPath() + "/navclasses");
                break;
            case "Edit":
                //1. update fitness class with parameters from edit modal
                dbFitnessClass.updateFitnessClass(UUID.fromString(req.getParameter("idEdit")),
                        new FitnessClass(req.getParameter("classNameEdit"),
                                Integer.parseInt(req.getParameter("maxPartEdit")),
                                0,
                                LocalDateTime.parse(req.getParameter("startDateTimeEdit"), DateTimeFormatter.ISO_DATE_TIME),
                                LocalDateTime.parse(req.getParameter("stopDateTimeEdit"), DateTimeFormatter.ISO_DATE_TIME),
                                true));
                //2. get fitness class updated
                FitnessClass fitnessClassEdit = dbFitnessClass.getFitnessClass(UUID.fromString(req.getParameter("idEdit")));
                //3. update modifications in google calendar if bookings have been made
                try{
                    //3.1 get all the bookings belonging to this class, id has not changed!
                    List<FitnessBooking> listFitnessBookings = dbFitnessBooking.getBookingsByClass(fitnessClassEdit);
                    //3.2 check if they have an eventId and if yes update the calendar events
                    for (FitnessBooking fBooking: listFitnessBookings) {
                        String eventId = fBooking.getEventId();
                        if (!eventId.isEmpty()) {
                            // Use access token to call Calendar API
                            GoogleCredential credential = new GoogleCredential().setAccessToken((String) req.getSession().getAttribute("accessToken"));
                            //create google calendar service
                            GoogleCalendarService googleCalendarService = new GoogleCalendarService(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential, "FitnessBooking");
                            //create calendar event object from eventId
                            Event event = googleCalendarService.getEvent(eventId);
                            //update event
                            googleCalendarService.updateGoogleCalendarEvent(fitnessClassEdit.getClassName(), fitnessClassEdit.getStartDateTime(),
                                    fitnessClassEdit.getEndDateTime(),eventId);
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                //4. redirect
                resp.sendRedirect(req.getContextPath() + "/navclasses");
                break;
            case "Book":
                //1. get the Fitness Class Object
                FitnessClass fitnessClassBook = dbFitnessClass.getFitnessClass(UUID.fromString(req.getParameter("idBook")));
                System.out.println(fitnessClassBook.toString());
                //2. get the Fitness Client object from session attributes
                FitnessClient fitnessClient = UserService.getInstance().getClientFromUser(req.getSession().getAttribute("authenticatedUser"),
                        req.getSession().getAttribute("authWithGoogleSignIn"));
                //3. check if signed with google sign in and insert calendar event
                Object auth = req.getSession().getAttribute("authWithGoogleSignIn");
                String eventId = "";
                if (auth.equals("yes")) {
                    //add calendar event
                    // Use access token to call Calendar API
                    GoogleCredential credential = new GoogleCredential().setAccessToken((String) req.getSession().getAttribute("accessToken"));
                    //set calendar event
                    GoogleCalendarService googleCalendarService = new GoogleCalendarService(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential, "FitnessBooking");
                    eventId = googleCalendarService.setGoogleCalendarEvent(fitnessClassBook.getClassName(), "Awesome Fitness Gym", "from Fitness Booking App",
                            fitnessClassBook.getStartDateTime(), fitnessClassBook.getEndDateTime());
                }
                //4. create the Fitness Booking object
                FitnessBooking fitnessBooking = new FitnessBooking(LocalDateTime.now().withNano(0), fitnessClient, fitnessClassBook, eventId);
                //5. check if booking allready made
                if (dbFitnessBooking.checkAllreadyBooked(fitnessBooking))
                {
                    //5.1 persist the Fitness Booking object
                    dbFitnessBooking.addFitnessBooking(fitnessBooking);
                    //5.2 update the Fitness Class object
                    ClassService.getInstance().addingParticipantsFitnessClass(fitnessClassBook);
                }
                //6. redirect
                resp.sendRedirect(req.getContextPath() + "/navclasses");
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/navclasses");
        }
    }
}
