<%@ page contentType="text/html" %>
<%@ taglib prefix="beginjsp" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>beginjsp:cleanhtml example</title>
</head>
<body>

<beginjsp:cleanhtml>
	<b>This is bold</b>
</beginjsp:cleanhtml>
<p>
<beginjsp:cleanhtml>
	<i>This is italic</i>
</beginjsp:cleanhtml>
<p>
<beginjsp:cleanhtml>
	<img src="/images/someimage.gif">
</beginjsp:cleanhtml>
<p>
<c:set var="unclean" 
	   value="<font face=verdana>This is in verdana</font>" 
	   scope="page"/>
	   
<beginjsp:cleanhtml>
	${unclean}
</beginjsp:cleanhtml>

</body>
</html>
