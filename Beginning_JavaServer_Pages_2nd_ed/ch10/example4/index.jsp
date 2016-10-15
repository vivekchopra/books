<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="showerr.jsp" %>
<html>
<head>
<jsp:useBean id="errgen" class="com.wrox.begjsp.ch10.ErrorGenerator" />

<title>Error Generating page</title>
</head>
<body>
       <h1>Page to Generate Error</h1>
<table>
<tr>
  <td><h3>${errgen.divideByZero}</h3></td>
</tr>
</table>


</body>
</html>
