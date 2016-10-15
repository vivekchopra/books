<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="data" required="true" type="java.util.Map" %>
<%@ attribute name="search" required="true" %>
<%@ attribute name="highlight" fragment="true" required="true" %>
<%@ attribute name="lolight" fragment="true" required="true" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="columnOne" required="false" %>
<%@ attribute name="columnTwo" required="false" %>

<c:if test="${empty columnOne}">
	<c:set var="columnOne" value="Key"/>
</c:if>

<c:if test="${empty columnTwo}">
	<c:set var="columnTwo" value="Value"/>
</c:if>

<table cellspacing=0 cellpadding=0 border=1>
<c:if test="${not empty title}">
<tr>
	<td colspan="3"><h1>${title}</h1></td>
</tr>
</c:if>
<tr>
	<th>Count</th>
	<th>${columnOne}</th>
	<th>${columnTwo}</th>
</tr>
<c:forEach items="${data}" var="thisElement" varStatus="status">
	<c:choose>
		<c:when test="${fn:containsIgnoreCase(thisElement.key, search) or
			            fn:containsIgnoreCase(thisElement.value, search)}">
			<tr bgcolor="<jsp:invoke fragment="highlight"/>">
		</c:when>
		<c:otherwise>
			<tr bgcolor="<jsp:invoke fragment="lolight"/>">
		</c:otherwise>
	</c:choose>
	<td>${status.count}</td>
	<td>${thisElement.key}</td>
	<td>${thisElement.value}</td>
	</tr>
</c:forEach>
</table>
