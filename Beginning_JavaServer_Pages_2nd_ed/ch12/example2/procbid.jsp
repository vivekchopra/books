<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Processing Bid Information</title>
</head>
<body> 
<h1>Bid Information Received</h1>
<table border="1">
<tr>
   <td>Name:</td> <td>${param.name}</td>
 </tr>
 
 <tr>
   <td>Item Number:</td> <td>${param.item}</td>
 </tr>
 <tr>
   <td>Bid Price:</td> <td> ${param.bid}</td>
 </tr>
 
</table>
</body>
</html>
