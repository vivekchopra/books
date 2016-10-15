<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table cellspacing=3 cellpadding=3 width="100%">
<tr>
	<td><h2>Category: ${category.name}</h2></td>
</tr>
<c:choose>
	<c:when test="${bookCount gt 0}">
		<tr>
			<td></td>
			<td><b>Price</b></td>
			<td></td>
		</tr>
		<c:forEach items="${books}" var="thisItem">
		<tr>
				<td>
					<b>${thisItem.name}</b><br>
					${thisItem.description}
				</td>		
				<td><fmt:formatNumber value="${thisItem.unitPrice}" type="currency"/></td>
				<td><a href="additem.do?book=${thisItem.id}">Add To Cart</a></td>
		</tr>
		</c:forEach>
	</c:when>
	<c:otherwise>
	<tr>
		<td colspan="3">There are no books in this category</td>
	</tr>
	</c:otherwise>
</c:choose>
</table>