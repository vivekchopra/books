<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" %>
<html>
<head>
<title>Processing Product Information</title>
<style>
.label { font-weight: bold; }
</style>
</head>

<body> 
<jsp:useBean id="localProd" class="com.wrox.begjsp.ch03.Product" />
<jsp:setProperty name="localProd" property="*" />
<h1>Information Received</h1>
<table border="1">
<tr>
   <td class="label" >SKU:</td> <td><jsp:getProperty name="localProd" property="sku"/> </td>
 </tr>
 
 <tr>
   <td class="label">Name:</td> <td><jsp:getProperty name="localProd" property="name"/> </td>
 </tr>
 <tr>
   <td class="label">Description:</td> <td><jsp:getProperty name="localProd" property="desc"/> </td>
 </tr>
 <tr>
   <td class="label">Price:</td> <td>   <fmt:formatNumber value="${localProd.price / 100}" type="currency"/></td>
 </tr>
 
</table>
</body>
</html>
