package com.andreitam.web.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/profile"})
public class ProfileFilter extends HttpFilter {
    static final Logger logger = LogManager.getLogger();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object aUsr = req.getSession().getAttribute("authenticatedUser");

        if(aUsr != null){
            System.out.println("web filter authenticated user: "+ aUsr);
            logger.warn("web filter authenticated user: "+ aUsr);
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() );
        }
    }
}
