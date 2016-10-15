<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
<title>Date Formatting</title>
</head>
<body>
<h1>Date Formatting and locale</h1>
<fmt:timeZone value="EST">
<jsp:useBean id="currentTime" class="java.util.Date"/>

<h3>English, Great Britain</h3>
<fmt:setLocale value="en_GB" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${currentTime}" /><br/>

<h3>English, USA</h3>
<fmt:setLocale value="en_US" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${currentTime}" /><br/>


<h3>French, France</h3>
<fmt:setLocale value="fr_FR" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${currentTime}" /><br/>

<h3>Japanese, Japan</h3>
<fmt:setLocale value="ja_JP" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${currentTime}" /><br/>

<h3>Korean, Korea</h3>
<fmt:setLocale value="ko_KR" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${currentTime}" /><br/>

<h3>Spanish, Spain</h3>
<fmt:setLocale value="es_ES" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${currentTime}" /><br/>


<h3>Arabic, Egypt</h3>
<fmt:setLocale value="ar_EG" />
<fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${currentTime}" /><br/>

</fmt:timeZone>
</body>
</html> 
