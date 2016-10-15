<%@ tag body-content="empty" dynamic-attributes="mapData" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${mapData}" var="thisElement">
	${thisElement.key} = ${thisElement.value}<br>
</c:forEach>