<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <c:choose>
    <c:when test="${param.portchoice == 'news'}">
      <jsp:include page="news.jsp" >
           <jsp:param name="user" value="${param.username}"/>
      </jsp:include>    
    </c:when>
    <c:when test="${param.portchoice =='weather'}">
      <jsp:include page="weather.jsp" >
           <jsp:param name="user" value="${param.username}"/>
      </jsp:include>    
    </c:when>
    <c:when test="${param.portchoice == 'entertainment'}">
      <jsp:include page="entertain.jsp" >
           <jsp:param name="user" value="${param.username}"/>
      </jsp:include>    
    </c:when>
    <c:otherwise>
       <head><title>System Portal</title></head>
       <body>
       <h1>Application logic problem detected!</h1>   
    </c:otherwise>
</c:choose>
</body>
</html>
