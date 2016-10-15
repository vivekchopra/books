<jsp:root 

          xmlns:c="http://java.sun.com/jsp/jstl/core"
          xmlns:jsp="http://java.sun.com/JSP/Page"
          version="2.0">
<html>
<head>
</head>
<body>

 <c:choose>
    <c:when test="${param.pg == 'news'}">
      <jsp:directive.include file="news.jsp" />
    </c:when>
    <c:otherwise>
      <jsp:directive.include file="data.jsp" />
    </c:otherwise>
</c:choose>
</body>
</html>
</jsp:root>