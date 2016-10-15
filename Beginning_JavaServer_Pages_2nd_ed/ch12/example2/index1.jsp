<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${empty param.action}">
     <jsp:forward page="bidform.jsp"/>
  </c:when>

  <c:when test="${param.action eq 'bidsubmit'}">
     <jsp:forward page="procbid.jsp"/>
  </c:when>
</c:choose>
