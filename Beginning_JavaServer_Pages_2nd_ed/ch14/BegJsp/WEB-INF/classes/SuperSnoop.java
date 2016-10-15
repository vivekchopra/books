import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.http.*;

public class SuperSnoop extends HttpServlet {
    
    private String makeTitle( String title )
    {
        return new String("<H2>"+title+"</H2>\n");
    }
    
    private String makeRow( String left, String right ) {
        StringBuffer sb = new StringBuffer(128);
        sb.append( "<tr>\n" );
        sb.append( "\t<td>"+left+"</td>\n");
        sb.append( "\t<td>"+right+"</td>\n");
        sb.append( "</tr>\n" );
        return sb.toString();
    }
    
    private String today()
    {
        Date now = new Date();
        DateFormat dateFormatter = DateFormat.getDateTimeInstance();
        return dateFormatter.format( now );
    }
    
    private String showHeaders( HttpServletRequest request ) {
        StringBuffer sb = new StringBuffer(512);
        Enumeration e = request.getHeaderNames();
        String key = null;
        String value = null;
        sb.append( makeTitle("Request Headers"));
        sb.append("<table>");
        while( e.hasMoreElements() ){
            key = (String)e.nextElement();
            value = request.getHeader(key);
            sb.append( makeRow( key, value ));
        }
        sb.append("</table>");
        return sb.toString();
    }
    
    private String showRequestInfo(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer(512);
        sb.append(makeTitle( "Request Info"));
        sb.append("<table>\n");
        sb.append( makeRow( "ContextPath", request.getContextPath() ));
        sb.append( makeRow( "Method", request.getMethod() ));
        sb.append( makeRow( "RequestURL", request.getRequestURL().toString()));
        sb.append( makeRow( "ServletPath", request.getServletPath() ));
        sb.append( makeRow( "CharacterEncoding", request.getCharacterEncoding() ));
        sb.append( makeRow( "ContentType", request.getContentType() ));
        sb.append( makeRow( "RemoteAddress", request.getRemoteAddr() ));
        sb.append( makeRow( "RemoteHost", request.getRemoteHost() ));
        sb.append( makeRow( "Scheme", request.getScheme() ));
        sb.append( makeRow( "ServerName", request.getServerName() ));
        sb.append( makeRow( "ServerPort", Integer.toString(request.getServerPort()) ));
        sb.append("</table>\n");
        return sb.toString();
    }

    private String showRequestParams( HttpServletRequest request )
    {
        StringBuffer sb = new StringBuffer(512);
        Enumeration e = request.getParameterNames();
        String key = null;
        String value = null;
        sb.append(makeTitle("Request Parameters"));
        sb.append("<table>");
        while( e.hasMoreElements() ){
            key = (String)e.nextElement();
            value = request.getParameter(key);
            sb.append( makeRow( key, value ));
        }
        sb.append("</table>");
        return sb.toString();
    }
    
    private String showSysProps() {
        StringBuffer sb = new StringBuffer(512);
        Properties p = System.getProperties();
        Enumeration e = p.propertyNames();
        String key = null;
        String value = null;
        sb.append(makeTitle("System Properties"));
        sb.append("<table>");
        sb.append(makeRow("System Time", today() ));
        while( e.hasMoreElements() ){
            key = (String)e.nextElement();
            value = p.getProperty( key );
            sb.append( makeRow( key, value ));
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String showInitParams() {
        StringBuffer sb = new StringBuffer(512);
        ServletContext context = getServletContext();
        Enumeration e = context.getInitParameterNames();
        String key = null;
        String value = null;
        sb.append(makeTitle("Initialization Parameters"));
        sb.append("<table>");
        while( e.hasMoreElements() ){
            key = (String)e.nextElement();
            value = context.getInitParameter(key);
            sb.append( makeRow( key, value ));
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String showServletContextInfo() 
    {
        StringBuffer sb = new StringBuffer(512);
        ServletContext context = getServletContext();
        sb.append(makeTitle("Servlet Context"));
        sb.append("<table>");
        sb.append( makeRow( "Server Info", context.getServerInfo()));
        sb.append( makeRow( "Servlet Context Name", context.getServletContextName()));
        sb.append( makeRow( "Real Path", context.getRealPath("/")));
        sb.append("</table>");
        return sb.toString();
    }
    
    private String showContextAttributes() {
        StringBuffer sb = new StringBuffer(512);
        ServletContext context = getServletContext();
        Enumeration e = context.getAttributeNames();
        String key = null;
        String value = null;
        sb.append(makeTitle("Servlet Context Attributes"));
        sb.append("<table>");
        while( e.hasMoreElements() ){
            key = (String)e.nextElement();
            value = context.getAttribute(key).toString();
            sb.append( makeRow( key, value ));
        }
        sb.append("</table>");
        return sb.toString();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SysProps Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println( today() );
        out.println( showHeaders(request) );
        out.println( showRequestInfo(request) );
        out.println( showRequestParams(request) );
        out.println( showServletContextInfo() );
        out.println( showContextAttributes() );
        out.println( showInitParams() );
        out.println( showSysProps() );

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        doGet(request, response);
    }
    
    public String getServletInfo() {
        return "Prints Java System Properties";
    }
}
