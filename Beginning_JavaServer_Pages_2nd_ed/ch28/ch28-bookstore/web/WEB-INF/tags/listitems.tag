<%@ tag body-content="empty" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="items" required="true" type="java.util.Set" %>

<table cellspacing=0 cellpadding=0 width="100%">
<tr>
	<td></td>
	<td><b>Unit Price</b></td>
	<td><b>Quantity</b></td>
	<td><b>Sub Total</b></td>
</tr>

<c:forEach items="${items}" var="thisItem" varStatus="status">
	<c:set value="${total + thisItem.value}" var="total"/>
	<c:set value="${thisItem.book}" var="book"/>
<tr>
		<td><b>${status.count}. ${book.name}</b></td>		
		<td><fmt:formatNumber value="${thisItem.unitPrice}" type="currency"/></td>			
		<td>${thisItem.qty}</td>	
		<td><fmt:formatNumber value="${thisItem.value}" type="currency"/></td>
</tr>
</c:forEach>
<tr>
	<td colspan="4">&nbsp;</td>
</tr>
<tr>
	<td colspan="3"><b>TOTAL</b></td>
	<td><b><fmt:formatNumber value="${total}" type="currency"/></b></td>			
</tr>
</table>	