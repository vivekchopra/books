<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>

<title>Currency Formatting</title>
</head>
<body>
<h1>Currency Formatting and locales</h1>

<h3>English, Great Britain</h3>
<fmt:setLocale value="en_GB" />
<fmt:formatNumber type="currency" value="80000" /><br/>

<h3>English, USA</h3>
<fmt:setLocale value="en_US" />
<fmt:formatNumber type="currency" value="80000" /><br/>


<h3>French, France</h3>
<fmt:setLocale value="fr_FR" />
<fmt:formatNumber type="currency" value="80000" /><br/>

<h3>Japanese, Japan</h3>
<fmt:setLocale value="ja_JP" />
<fmt:formatNumber type="currency" value="80000" /><br/>

<h3>Korean, Korea</h3>
<fmt:setLocale value="ko_KR" />
<fmt:formatNumber type="currency" value="80000" /><br/>


<h3>Spanish, Spain</h3>
<fmt:setLocale value="es_ES" />
<fmt:formatNumber type="currency" value="80000" /><br/>


<h3>Arabic, Egypt</h3>
<fmt:setLocale value="ar_EG" />
<fmt:formatNumber type="currency" value="80000" /><br/>



<h3>Using Local Numeric Formatting for Different Currency</h3>
<h4>English, Great Britan</h4>
<fmt:setLocale value="en_GB" />



<fmt:formatNumber type="currency" value="80000" /><br/>
<fmt:formatNumber type="currency" value="80000" currencyCode="EUR"/><br/>

</body>
</html> 
