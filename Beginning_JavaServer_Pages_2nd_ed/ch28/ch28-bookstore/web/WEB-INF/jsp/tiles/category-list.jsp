<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table cellspacing=3 cellpadding=3 width="100%">
<tr>
	<td></td>
	<td><b>No. Titles</b></td>
</tr>
<c:forEach items="${categories}" var="thisItem">
<tr>
		<td valign="top"><h3><a href="browsecategory.do?cat=${thisItem.id}">
									  ${thisItem.name}</a>
									  </h3>${thisItem.description}</td>
		<td valign="top">${thisItem.bookCount}</td>
</tr>
</c:forEach>
</table>