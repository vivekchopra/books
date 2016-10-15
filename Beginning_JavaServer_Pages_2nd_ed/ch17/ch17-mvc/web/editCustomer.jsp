<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="customer" value="${requestScope.customer}"/>
<html>
<head>
	<title>Edit Customer</title>
</head>
<body>
<form action="controller?action=editcustomerexe">
<table cellspacing="3" cellpadding="3" border="1" width="60%">	
<input type="hidden" name="id" value="${customer.id}">
<tr>
	<td><b>First Name:</b> 
  <td><input type="text" name="firstname" value="${customer.firstName}"></td>
</tr>
<tr>
	<td><b>Last Name:</b> 
  <td><input type="text" name="lastname" value="${customer.lastName}"></td>
</tr>
<tr>
	<td><b>Address:</b> 
  <td><input type="text" size="50" name="lastname" value="${customer.address}"></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="edit customer"></td>
</tr>
</table>
</form>
</body>
</html>