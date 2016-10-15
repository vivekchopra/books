<%@ tag body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:doBody var="content" scope="page"/>

<c:set var="content" value="${fn:escapeXml(content)}"/>

<c:set var="enabledSomeHTML" value="${fn:replace(content, '&lt;b&gt;','<b>')}"/>
<c:set var="enabledSomeHTML" value="${fn:replace(enabledSomeHTML, '&lt;/b&gt;','</b>')}"/>

<c:set var="enabledSomeHTML" value="${fn:replace(enabledSomeHTML, '&lt;i&gt;','<i>')}"/>
<c:set var="enabledSomeHTML" value="${fn:replace(enabledSomeHTML, '&lt;/i&gt;','</i>')}"/>

${enabledSomeHTML}





