package com.wrox.begjsp.ch27.servlet;

import com.wrox.begjsp.ch27.dal.PublisherDB;
import com.wrox.begjsp.ch27.dal.PublisherDBMemoryImpl;
import com.wrox.begjsp.ch27.dal.UserProfileDB;
import com.wrox.begjsp.ch27.dal.UserProfileDBMemoryImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Loads the memory resident database at startup time
 */
public class DBServlet extends HttpServlet
{
    private PublisherDB publisherDB;
    private UserProfileDB userProfileDB;

    public void init() throws ServletException
    {
        
		// Get Fully Qualified Path to Properties File
		String databasePath = getServletContext().getRealPath("/") + getInitParameter("databasePath");
		System.out.println("*** MemoryDB initializing using databasePath :" + databasePath);

        // Create an instance of PublisherDB and UserProfileDB
        publisherDB = PublisherDBMemoryImpl.getInstance(databasePath);
        userProfileDB = UserProfileDBMemoryImpl.getInstance(databasePath);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>DBServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Called GET method of the servlet.</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
