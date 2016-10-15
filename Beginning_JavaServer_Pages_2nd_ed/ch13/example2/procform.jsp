<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<html>
<fmt:setLocale value="${param.locale}"  />
<head>
<fmt:bundle basename="app">
<title><fmt:message key="appInfo"/></title>
</head>
<body>
<h1><fmt:message key="appInfo"/></h1>
</br>

<table border="1">
<tr>
<td><fmt:message key="lastName"/></td>
<td>${param.lastname}</td>
</tr>

<tr>
<td><fmt:message key="firstName"/></td>
<td>${param.firstname}</td>
</tr>


<tr>
<td><fmt:message key="postalCode"/></td>
<td>${param.postcode}</td>
</tr>


<tr>
<td><fmt:message key="password"/></td>
<td>${param.pass}</td>
</tr>




</table>


</body>
</fmt:bundle>

</html>











