<%@ taglib prefix="beginjsp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="appVar" value="this is an application variable" scope="application"/>
<c:set var="sessVar" value="this is a session variable" scope="session"/>
<c:set var="rVar" value="this is a request variable" scope="request"/>
<c:set var="pVar" value="this is a page variable set in the JSP" scope="page"/>

<b>Calling in the JSP page:</b>
<p>
Application: ${applicationScope.appVar}<br>
Session: ${sessionScope.sessVar}<br>
Request: ${requestScope.rVar}<br>
Page: ${pageScope.pVar}
<p>

<beginjsp:scope/>

<p>
<b>Calling in the JSP page after the tag:</b>
<p>
Application: ${applicationScope.appVar}<br>
Session: ${sessionScope.sessVar}<br>
Request: ${requestScope.rVar}<br>
Page: ${pageScope.pVar}
