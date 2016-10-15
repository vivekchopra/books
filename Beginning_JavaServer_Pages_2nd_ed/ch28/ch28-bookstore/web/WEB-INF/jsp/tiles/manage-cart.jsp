<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<script language="javascript">

function doSomething(command)
{
	alert(command);
}

</script>
<table cellspacing=3 cellpadding=3 width="100%">
<tr>
	<td colspan="5"><h3>Manage your Shopping Cart</h3></td>
</tr>
<c:choose>
	<c:when test="${cart.itemCount gt 0}">
		<html:form action="managecart.do">
		<html:hidden property="command" value="update"/>
		<tr>
			<td colspan="3">
			  <a href="managecart.do?command=clear">
			    Click here to empty cart
			  </a>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><b>Unit Price</b></td>
			<td><b>Quantity</b></td>
			<td><b>Sub Total</b></td>
		</tr>
		<c:forEach items="${cart.items}" var="thisItem" varStatus="status">
		  <c:set value="${thisItem.book}" var="book"/>
		<tr>
				<td>
					<b>${status.count}. ${book.name}</b>
				</td>		
				<td><fmt:formatNumber value="${thisItem.unitPrice}" type="currency"/></td>				
				<td><html:text size="3" property="value(${thisItem.bookId})"/></td>
				<td><fmt:formatNumber value="${thisItem.value}" type="currency"/></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><b>TOTAL</b></td>
			<td><b><fmt:formatNumber value="${cart.value}" type="currency"/></b></td>			
		</tr>
		<tr>
			<td colspan="2"></td>
			<td><html:submit value="update cart"/>
			<td></td>
		</html:form>		
	</c:when>
	
	<c:otherwise>
		<tr>
			<td colspan="5">Your shopping cart is empty.</td>
		</tr>
	</c:otherwise>	
	
</c:choose>
</table>