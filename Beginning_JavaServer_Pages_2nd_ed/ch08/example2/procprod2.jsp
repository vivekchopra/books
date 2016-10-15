<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${param.docformat == 'xml'}">
  <jsp:forward page="prodxml.jsp"/>
</c:when>
<c:otherwise>
  <jsp:forward page="prodhtml.jsp"/>
</c:otherwise>
</c:choose>

