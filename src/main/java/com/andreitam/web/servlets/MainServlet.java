package com.andreitam.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getSession().getAttribute("authenticatedUser");
        req.setAttribute("user", user);
        //display user email
        Object email = req.getSession().getAttribute("authUserEmail");
        req.setAttribute("userEmail", email);
        req.getRequestDispatcher("/jsps/main.jsp").forward(req, resp);
    }

}