package com.andreitam.web.servlets;

import com.andreitam.web.service.GoogleCalendarService;
import com.andreitam.web.entity.FitnessBooking;
import com.andreitam.web.entity.FitnessClass;
import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.model.DBFitnessBooking;
import com.andreitam.web.service.ClassService;
import com.andreitam.web.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.model.Event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/navbookings"})
public class NavBookingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. display user email
        Object email = req.getSession().getAttribute("authUserEmail");
        req.setAttribute("userEmail",email);
        //2. initialise database object
        DBFitnessBooking dbFitnessBooking = new DBFitnessBooking();
        //3. get the Fitness Client object from session attributes
        FitnessClient fitnessClient = UserService.getInstance().getClientFromUser(req.getSession().getAttribute("authenticatedUser"),
                req.getSession().getAttribute("authWithGoogleSignIn"));
        Object aUsr = req.getSession().getAttribute("authenticatedUser");
        //4. pagination
        int page = 1;
        int recordsPerPage = 7;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        List<FitnessBooking> listFitnessBookings = dbFitnessBooking.getBookingsByClientPagination(page,recordsPerPage, fitnessClient.getId());
        Long noOfRecords = dbFitnessBooking.getNoOfRecordsByClient(fitnessClient.getId());
        int noOfRecordsPerPage = listFitnessBookings.size();
        int noOfPages = (int) Math.ceil(noOfRecords*1.0/recordsPerPage);
        req.setAttribute("fitnessBookings",listFitnessBookings);
        req.setAttribute("noOfPages",noOfPages);
        req.setAttribute("noOfRecordsPerPage",noOfRecordsPerPage);
        req.setAttribute("noOfRecords",noOfRecords);
        req.setAttribute("currentPage",page);
        //5. dispatch
        req.getRequestDispatcher("/jsps/bookings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //initialise database object
        DBFitnessBooking dbFitnessBooking = new DBFitnessBooking();
        //delete function from delete modal
        String action = req.getParameter("action");
        if (action.equals("Delete")) {
            //1 create fitness class object to be modified
            FitnessClass fitnessClass = dbFitnessBooking.getFitnessBooking(UUID.fromString(req.getParameter("idDelete"))).getFitnessClass();
            //2 check if signed with google sign in and delete calendar event
            Object auth = req.getSession().getAttribute("authWithGoogleSignIn");
            if (auth.equals("yes")) {
                try {
                    //get eventId from fitness booking
                    String eventId = dbFitnessBooking.getFitnessBooking(UUID.fromString(req.getParameter("idDelete"))).getEventId();
                    // Use access token to call Calendar API
                    GoogleCredential credential = new GoogleCredential().setAccessToken((String) req.getSession().getAttribute("accessToken"));
                    //create google calendar service
                    GoogleCalendarService googleCalendarService = new GoogleCalendarService(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential, "FitnessWebApp");
                    //create calendar event object from eventId
                    Event event = googleCalendarService.getEvent(eventId);
                    //delete event
                    googleCalendarService.deleteGoogleCalendarEvent(event);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            //3. delete fitness booking
            dbFitnessBooking.deleteFitnessBooking(UUID.fromString(req.getParameter("idDelete")));
            //4. update the Fitness Class object
            ClassService.getInstance().deletingParticipantsFitnessClass(fitnessClass);
            //5. redirect
            resp.sendRedirect(req.getContextPath() + "/navbookings");
        }
    }
}
