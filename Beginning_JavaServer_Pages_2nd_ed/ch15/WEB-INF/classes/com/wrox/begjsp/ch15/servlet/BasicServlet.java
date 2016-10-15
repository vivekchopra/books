package com.wrox.begjsp.ch15.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

public class BasicServlet extends HttpServlet {

public void init(ServletConfig config) throws ServletException {
super.init(config);
}

public void destroy() {
}

protected void processRequest(HttpServletRequest request,
    HttpServletResponse response)
throws ServletException, java.io.IOException {

try{
response.setContentType("text/html");
java.io.PrintWriter out = response.getWriter();
out.write("<html>\n");
out.write("<head>\n");
out.write("<title>Basic Servlet</title>\n");
out.write("</head>\n");
out.write("<body>\n");
out.write("<h1>Hello!</h1>\n");
out.write("</body>\n");
out.write("</html>");
out.close();
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
