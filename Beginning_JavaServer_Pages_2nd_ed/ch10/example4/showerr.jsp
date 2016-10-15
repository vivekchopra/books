<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" %>

<html>
<head>
<title>An Error is detected</title>
</head>
<body>
        <h1>Error Detected</h1>
<table width="600" border="1">

<tr valign="top">
  <td ><b>Error:</b></td>
  <td>${pageContext.exception}</td>
</tr>

<tr valign="top">
  <td><b>URI:</b></td>
  <td>${pageContext.errorData.requestURI}</td>
</tr>


<tr valign="top">
  <td><b>Status code:</b></td>
  <td>${pageContext.errorData.statusCode}</td>
</tr>

<tr valign="top">
  <td><b>Stack trace:</b></td>

  <td> 
   <c:forEach var="trace" items="${pageContext.exception.stackTrace}">
    <p>${trace}</p>
   </c:forEach>
   </td>
</tr>

</table>

</body>
</html>
