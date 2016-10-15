<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Processing Product Information</title>
</head>
<body> 
<jsp:useBean id="localProd" class="com.wrox.begjsp.ch03.Product" />
<jsp:setProperty name="localProd" property="*" />
<h1>Product Information Received</h1>
<table border="1">
<tr>
   <td>SKU:</td> <td><jsp:getProperty name="localProd" property="sku"/> </td>
 </tr>
 
 <tr>
   <td>Name:</td> <td><jsp:getProperty name="localProd" property="name"/> </td>
 </tr>
 <tr>
   <td>Description:</td> <td><jsp:getProperty name="localProd" property="desc"/> </td>
 </tr>
 <tr>
   <td>Price:</td> <td> ${localProd.price}</td>
 </tr>
 
</table>
</body>
</html>
