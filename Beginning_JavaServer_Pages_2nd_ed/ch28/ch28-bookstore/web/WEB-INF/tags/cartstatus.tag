<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="cart" scope="session" class="com.wrox.begjsp.ch28.bookstore.ShoppingCart"/>

<table width="200" height="100%" bgcolor="white" 
	   cellspacing="2" 
	   cellpadding="2" border="0">
<thead>
<tr>
	<th colspan="2"><a href="managecart.do">Shopping Cart</a></th>
</tr>
<tbody>
<tr>	
	<td width="100%" colspan="2">
	There are ${cart.itemCount} items in the cart
	</td>
</tr>
<tr>	
	<td><b>Value:</b></td>
	<td width="50%"><fmt:formatNumber value="${cart.value}" type="currency"/></td>
</tr>
</table>