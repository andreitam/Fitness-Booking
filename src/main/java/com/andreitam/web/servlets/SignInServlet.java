package com.andreitam.web.servlets;

import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.entity.FitnessGoogleClient;
import com.andreitam.web.service.GoogleUserService;
import com.andreitam.web.service.UserService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {""})
public class SignInServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email =  req.getParameter("email");
        String password =  req.getParameter("password");
        System.out.println(email+ " " + password);
        FitnessClient fitnessClient = null;
        //authenticate  client
        if (email != null & password != null) { fitnessClient = UserService.getInstance().authenticateUser(email, password); }
        else {
            System.out.println("user & pass submitted empty from form");
            logger.warn("user & pass submitted empty from form");
        }
        //set authenticate  client
        if (fitnessClient != null) {
                req.getSession().setAttribute("authenticatedUser", fitnessClient);
                req.getSession().setAttribute("authUserEmail", fitnessClient.getEmailAddress());
                req.getSession().setAttribute("authWithGoogleSignIn", "no");
                req.getSession().setAttribute("authUserPower", false);
                System.out.println("user authenticated");
                resp.sendRedirect(req.getContextPath() + "/main");
        }
        else {
                System.out.println("user & pass completed but not registered, user must register");
                logger.warn("user & pass completed but not registered, user must register");
                resp.sendRedirect(req.getContextPath() + "/register");
        }
    }
}
