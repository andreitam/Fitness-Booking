package com.andreitam.web.servlets;

import com.andreitam.web.entity.FitnessBooking;
import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.model.DBFitnessBooking;
import com.andreitam.web.model.DBFitnessClient;
import com.andreitam.web.model.DBFitnessGoogleClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/navmembers"})
public class NavMembersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. display user email
        Object email = req.getSession().getAttribute("authUserEmail");
        req.setAttribute("userEmail", email);
        //2. initialise database object
        DBFitnessClient dbFitnessClient = new DBFitnessClient();
        //3. pagination
        int page = 1;
        int recordsPerPage = 7;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        List<FitnessClient> listFitnessClients = dbFitnessClient.getFitnessClientsPagination(page,recordsPerPage);
        Long noOfRecords = dbFitnessClient.getNoOfRecords();
        int noOfRecordsPerPage = listFitnessClients.size();
        int noOfPages = (int) Math.ceil(noOfRecords*1.0/recordsPerPage);
        req.setAttribute("fitnessClients",listFitnessClients);
        req.setAttribute("noOfPages",noOfPages);
        req.setAttribute("noOfRecordsPerPage",noOfRecordsPerPage);
        req.setAttribute("noOfRecords",noOfRecords);
        req.setAttribute("currentPage",page);
        //4. dispatch
        req.getRequestDispatcher("/jsps/members.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/navmembers");
    }
}