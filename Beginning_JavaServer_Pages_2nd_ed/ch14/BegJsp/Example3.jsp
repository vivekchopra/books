<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>JSP Page</title></head>
<body>
<c:forEach var="counter" begin="1" end="10" step="1" >
    <c:out value="${counter-5}"/></br>
    <% System.out.println( "counter="+pageContext.findAttribute("counter") ); %>
</c:forEach>
</body>
</html>
