<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.net.URL" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="org.apache.log4j.*" %>
<%@page import="org.apache.log4j.config.PropertyPrinter" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Log Reset</title></head>
<body>
<pre>
<%
    LogManager.resetConfiguration();
    ClassLoader cl = this.getClass().getClassLoader();
    URL log4jprops = cl.getResource("log4j.properties");
    if (log4jprops != null) 
    {
        PropertyConfigurator l4jconfig = new PropertyConfigurator();
        l4jconfig.configure(log4jprops);
    }
    out.println("#Log4j configuration");
    PrintWriter pw = new PrintWriter( out );
    PropertyPrinter pp = new PropertyPrinter(pw);
    pp.print(pw);
    out.println("#End of Config");
%>
</pre>
</body>
</html>