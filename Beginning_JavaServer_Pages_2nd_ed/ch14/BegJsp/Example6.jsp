<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.logging.Logger" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>JSP Page</title></head>
<body>
<% 
    Logger logger = Logger.getLogger(this.getClass().getName()); 
%>
<c:forEach var="loopCount" begin="1" end="10" step="1" >
    <c:set var="myCount" value="${loopCount-5}" />
    <c:out value="${myCount}"/></br>
    <% String message = "loopCount="
          + pageContext.findAttribute("loopCount")
          + " myCount="
          + pageContext.findAttribute("myCount");
       logger.info( message );
    %>

</c:forEach>
</body>
</html>