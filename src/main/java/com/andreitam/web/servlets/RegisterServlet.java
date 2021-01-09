package com.andreitam.web.servlets;

import com.andreitam.web.entity.FitnessClient;
import com.andreitam.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsps/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //register standard user
        FitnessClient fitnessClient = UserService.getInstance().registerUser(req.getParameter("inputName"),
                req.getParameter("inputEmail"),
                req.getParameter("inputPassword"),
                req.getParameter("inputPhone"),
                req.getParameter("inputBirthday"),
                req.getParameter("exampleRadios"),
                true);
        req.getSession().setAttribute("authenticatedUser", fitnessClient);
        req.getSession().setAttribute("authUserEmail", fitnessClient.getEmailAddress());
        req.getSession().setAttribute("authWithGoogleSignIn", "no");
        req.getSession().setAttribute("authUserPower", false);
        resp.sendRedirect(req.getContextPath() + "/main");
    }
}
