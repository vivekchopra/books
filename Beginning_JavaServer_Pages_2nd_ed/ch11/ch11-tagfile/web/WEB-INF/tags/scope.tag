<%@ tag body-content="empty" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pVar" value="this is a page variable set in the Tag File" scope="page"/>

<b>Calling in the Tag File:</b>
<p>
Application: ${applicationScope.appVar}<br>
Session: ${sessionScope.sessVar}<br>
Request: ${requestScope.rVar}<br>
Page: ${pageScope.pVar}

<c:set var="sessVar" value="this is a changed session variable" scope="session"/>