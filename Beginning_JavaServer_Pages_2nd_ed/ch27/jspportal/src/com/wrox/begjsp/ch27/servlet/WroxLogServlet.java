package com.wrox.begjsp.ch27.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import org.apache.log4j.PropertyConfigurator;

public class WroxLogServlet extends HttpServlet {

    public void init()
    throws ServletException {
        // Get Fully Qualified Path to Properties File
        String config = getServletContext().getRealPath("/") + getInitParameter("log4jconfig");
        System.out.println("*** LoggingServlet Initialized using file :" + config);

        // Initialize Properties for All Servlets
        PropertyConfigurator.configure(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>LoggingServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Called GET method of the servlet.</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    public void destroy() { }
}