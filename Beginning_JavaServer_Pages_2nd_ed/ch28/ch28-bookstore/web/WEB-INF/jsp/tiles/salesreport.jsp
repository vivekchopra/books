<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="begjsp" tagdir="/WEB-INF/tags" %>

<table cellspacing=3 cellpadding=3 width="100%">
<tr>
	<td><h2>Sales Report</h2></td>
</tr>
<c:forEach items="${orders}" var="thisOrder">
	<c:set value="${thisOrder.orderItems}" var="orderItems"/>
<tr bgcolor="lightgrey">
		<td><b>Order Number: ${thisOrder.id}</b></td>
		<td>Customer Name: ${thisOrder.firstName} ${thisOrder.lastName}<br>
		    Address: ${thisOrder.address} ${thisOrder.zipCode}
</tr>
<tr bgcolor="lightgrey">		
		<td colspan="2">Decision: ${thisOrder.status.name}</td>	
</tr>
<tr>
		<td colspan="2">
			<begjsp:listitems items="${orderItems}"/>
		</td>
</tr>
</c:forEach>
</table>
