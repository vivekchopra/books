package com.wrox.begjsp.ch15.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.HashMap;

public class ControllerServlet extends HttpServlet {
  private HashMap forwards;
  private final static String HOT="hot";
  private final static String COOL="cool";

  public void init(ServletConfig config) throws   
      ServletException {
    super.init(config);
    forwards = new HashMap();
    forwards.put(HOT, config.getInitParameter(HOT));
    forwards.put(COOL, config.getInitParameter(COOL));
    }

  public void destroy() {
    }

  protected void processRequest(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, java.io.IOException {
    try{
      //forward request to the associated page
      ServletContext context = getServletContext();
      String logicalName = request.getServletPath();
      String physicalURL = "/";
      logicalName= logicalName.substring(logicalName.lastIndexOf('/') + 1,  logicalName.indexOf('.'));

      if (logicalName.equals(HOT))
        physicalURL= (String) forwards.get(HOT);

      if (logicalName.equals(COOL))
        physicalURL= (String) forwards.get(COOL);

      RequestDispatcher dispatcher = context.getRequestDispatcher(physicalURL);
      dispatcher.forward(request, response);
      }catch(Exception e){
          throw new ServletException(e);
      }
     }

  protected void doGet(HttpServletRequest request,
     HttpServletResponse response)
     throws ServletException, java.io.IOException {
     processRequest(request, response);
   }

  protected void doPost(HttpServletRequest request,
     HttpServletResponse response)
     throws ServletException, java.io.IOException {
     processRequest(request, response);
    }

}
