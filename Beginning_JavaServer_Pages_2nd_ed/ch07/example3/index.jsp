<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>

 <c:choose>
    <c:when test="${param.pg == 'news'}">
      <%@ include file="news.jsp" %>
    </c:when>
    <c:otherwise>
      <%@ include file="data.jsp" %>
    </c:otherwise>
</c:choose>
</body>
</html>
