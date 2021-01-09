package com.andreitam.web.servlets;

import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.model.DBFitnessClient;
import com.andreitam.web.model.DBFitnessGoogleClient;
import com.andreitam.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@WebServlet(urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //initialise objects
        DBFitnessClient dbFitnessClient = new DBFitnessClient();
        DBFitnessGoogleClient dbFitnessGoogleClient = new DBFitnessGoogleClient();
        //first get the Fitness Client object from session attributes
        FitnessClient fitnessClient = UserService.getInstance().getClientFromUser(req.getSession().getAttribute("authenticatedUser"),
                req.getSession().getAttribute("authWithGoogleSignIn"));
        //set attribute to fill form with data
        req.setAttribute("fitnessClient",fitnessClient);
        String gender = fitnessClient.getGender().toLowerCase();
        switch(gender) {
            case "male":
                req.setAttribute("genderMale","checked");
                break;
            case "female":
                req.setAttribute("genderFemale","checked");
                break;
            case "rather not say":
                req.setAttribute("genderNot","checked");
                break;
            default:
                // code block
        }
        req.getRequestDispatcher("/jsps/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //initialise objects
        DBFitnessClient dbFitnessClient = new DBFitnessClient();
        dbFitnessClient.updateFitnessClient(UUID.fromString(req.getParameter("id")),
                new FitnessClient(req.getParameter("inputName"),
                        req.getParameter("inputEmail"),
                        req.getParameter("inputPassword"),
                        req.getParameter("inputPhone"),
                        LocalDate.parse(req.getParameter("inputBirthday"), DateTimeFormatter.ISO_DATE),
                        req.getParameter("exampleRadios"),
                        true
                )
        );
        resp.sendRedirect(req.getContextPath() + "/main");
    }

}
