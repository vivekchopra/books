<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.wrox.begjsp.ch03.*" %>
<html>
<head>
<%
  pageContext.setAttribute("myCats", EShop.getCats());
%>
</head>
<body>
  <jsp:useBean id="myProduct" class="com.wrox.begjsp.ch03.Product">
    <jsp:setProperty name="myProduct" property="sku" value="12345"/>
    <jsp:setProperty name="myProduct" property="name" value="DSL Modem"/>
  </jsp:useBean>

  <jsp:useBean id="myCats" class="java.util.ArrayList"/>

<table border="1">
 <tr>
    <td>Sku:</td><td><%= myProduct.getSku() %></td>
 </tr>
<tr>
    <td>Name:</td><td>${myProduct.name}</td>
 </tr>
</table>

  <jsp:useBean id="myMap"  class="java.util.HashMap" />
  <jsp:useBean id="myMap2"  class="java.util.HashMap"  type="java.util.Map"/>


<table border="1">
<tr>
<th>ID</th><th>Category</th></tr>
</tr>
<c:forEach var="curcat" items="${myCats}">
 <tr>
    <td>${curcat.id}</td><td>${curcat.name}</td>
 </tr>
</c:forEach>
</table>



 </body>
</html>
