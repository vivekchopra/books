<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:importAttribute/>

<table cellspacing="0" cellpadding="0" border="0">
<c:forEach items="${menuList}" var="thisItem">
	<tr>
	<td><a href="${thisItem.link}">${thisItem.value}</a></td>
	</tr>
</c:forEach>
</table>