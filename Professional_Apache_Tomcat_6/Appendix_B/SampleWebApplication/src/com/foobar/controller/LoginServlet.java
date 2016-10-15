package com.foobar.controller;
import com.foobar.model.LoginCredentials;
import com.foobar.model.User;

import com.foobar.service.LoginService;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Log in a user based on passed credentials (username, password).
 */
public class LoginServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(
            "com.foobar.controller.LoginServlet");
    private static String errorPage = "error.jsp";
    private static String successPage = "success.jsp";

    /**
     * Handle the login form
     *
     * @param request HTTP Request object
     * @param response HTTP Response object
     *
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String username = request.getParameterValues("name")[0];
        String password = request.getParameterValues("pass")[0];

        // Check username password
        User user = LoginService.login(new LoginCredentials(username, password));
        boolean verifiedUser = (user != null);

        // Forward to web application (successful login) or error page (failed login)
        String forwardPage = verifiedUser ? successPage : errorPage;
        request.getRequestDispatcher(forwardPage).forward(request, response);
    }

    /**
     * HTTP GET not supported, print error message
     *
     * @param request HTTP Request object
     * @param response HTTP Response object
     *
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /* Write out error message  */
        logger.log(Level.WARNING,
            "Invalid GET method invoked on Login Servle- only POST supported");

        ServletOutputStream out = response.getOutputStream();
        response.setContentType("text/html");
        out.println("Error: Get method not supported by servlet");
        out.close();
    }
}
