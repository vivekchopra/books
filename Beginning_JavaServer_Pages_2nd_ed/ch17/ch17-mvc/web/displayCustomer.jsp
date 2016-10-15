<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="customer" value="${requestScope.customer}"/>
<html>
<head>
	<title>Display Customer</title>
</head>
<body>

<table cellspacing="3" cellpadding="3" border="1" width="60%">
<tr>
	<td colspan="2"><b>Customer:</b> 
     ${customer.firstName}	${customer.lastName}
	</td>
</tr>
<tr>
	<td><b>Id</b></td>
	<td>${customer.id}</td>
</tr>
<tr>
	<td><b>First Name</b></td>
	<td>${customer.firstName}</td>
</tr>
<tr>
	<td><b>Last Name</b></td>
	<td>${customer.lastName}</td>
</tr>
<tr>
	<td><b>Address</b></td>
	<td>${customer.address}"</td>
</tr>
<tr>
	<td colspan="2">
	    <a href="controller?action=editcustomer&id=${customer.id}">
	    Edit This Customer
	    </a>
	</td>
</tr>
</table>
</body>
</html>