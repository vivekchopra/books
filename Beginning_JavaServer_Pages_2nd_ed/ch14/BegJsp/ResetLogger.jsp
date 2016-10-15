<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.logging.LogManager" %>
<%@page import="java.util.logging.Logger" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Log Reset</title></head>
<body>
  <% 
    LogManager lm = LogManager.getLogManager();
    lm.readConfiguration();
    Logger logger = Logger.getLogger("org.apache.jsp");
    out.println("Logger("+logger.getName()+") is now set to "+logger.getLevel());
  %>
</body>
</html>