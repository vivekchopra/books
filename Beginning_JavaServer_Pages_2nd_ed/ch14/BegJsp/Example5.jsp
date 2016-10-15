<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>JSP Page</title></head>
<body>
<c:forEach var="loopCount" begin="1" end="10" step="1" >
    <c:set var="myCount" value="${loopCount-5}" />
    <c:out value="${myCount}"/></br>
    <% String message = "loopCount="
          + pageContext.findAttribute("loopCount")
          + " myCount="
          + pageContext.findAttribute("myCount");
       this.log( message );
    %>

</c:forEach>
</body>
</html>