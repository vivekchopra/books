<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Display Customer List</title>
</head>
<body>

<table cellspacing="3" cellpadding="3" border="1" width="500">
<tr>
	<td colspan="4"><b>Customer List</b></td>
</tr>
<tr>
	<td><b>Id</b></td>
	<td><b>First Name</b></td>
	<td><b>Last Name</b></td>
	<td><b>Address</b></td>
</tr>
<c:forEach var="customer" items="${requestScope.customers}">
<tr>
	<td>
		<a href="controller?action=displaycustomer&id=${customer.id}">
			${customer.id}
		</a>
	</td>
	<td>${customer.firstName}</td>
	<td>${customer.lastName}</td>
	<td>${customer.address}</td>
</tr>
</c:forEach>
</table>
</body>
</html>