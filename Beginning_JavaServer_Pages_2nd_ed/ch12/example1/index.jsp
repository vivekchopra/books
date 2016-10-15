<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${empty param.action}">
     <jsp:forward page="prodform.jsp"/>
  </c:when>

  <c:when test="${param.action eq 'prodsubmit'}">
     <jsp:forward page="procprod.jsp"/>
  </c:when>
</c:choose>
