<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" %>
<html>
<head>
<title>Error in JSP directives and actions</title>
</head>
<body>
<h1>Page with error in JSP directive and actions</h1>
<c:catch>
<jsp:include page="nosuch.jsp"  />
<jsp:setProperty name="errobj" property="nosuch" value="This is invalid" />
</c:catch>
</body>
</html>
