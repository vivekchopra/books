<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="data" required="true" type="java.util.Map" %>
<%@ attribute name="search" required="true" %>
<%@ attribute name="highlight" fragment="true" required="true" %>
<%@ attribute name="lolight" fragment="true" required="true" %>
<%@ attribute name="result" fragment="true" required="false" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="columnOne" required="false" %>
<%@ attribute name="columnTwo" required="false" %>
<%@ attribute name="countVar" required="true" rtexprvalue="false" %>
<%@ variable name-from-attribute="countVar" 
			 alias="counter" 
			 variable-class="java.lang.Integer" scope="NESTED"%>

<c:set var="counter" value="0"/>

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
			<c:set var="counter" value="${counter + 1}"/>		
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
<tr>	
	<td colspan="3"><jsp:invoke fragment="result"/></td>
</tr>
</table>
