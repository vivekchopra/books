<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wrox.begjsp.ch28.bookstore.BookstoreConstants"%>
<c:set value="<%=String.valueOf(BookstoreConstants.APPROVED_ID)%>" var="approved"/>

<c:choose>
	<c:when test="${order.status.id eq approved}">
		<table cellspacing=3 cellpadding=3 border=0 width=500>
		<tr>
			<td><h3>Order Completed</h3></td>
		</tr>
		<tr>
			<td>Your order has been approved.<p>
			    For your reference the order number is: ${order.id}.<P>
			    The goods will be shipped to the following address as soon as possible:</td>
		</tr>
		<tr>
			<td>${order.firstName} ${order.lastName}<br>
				  ${order.address}<br>
				  ${order.zipCode}</td>
		</tr>
		</table>
	</c:when>
	<c:otherwise>
	 	<table cellspacing=3 cellpadding=3 border=0 width=500>
		<tr>
			<td><h3>There was a problem</h3></td>
		</tr>
		<tr>
			<td>Your order has been declined by your credit card's financial institution.<p>
			    For your reference the order number is: ${order.id}.
			    <P>
			    If you would like to try again please click <a href="javascript:history.back(-1)">here</a>.
			    If the problem continues, please contact you bank as soon as possible.
			    </td>
		</tr>
		</table>
	</c:otherwise>
</c:choose>