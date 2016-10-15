<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wf" uri="http://www.wrox.com/begjsp/el-functions-taglib" %>

<html>
<head>
<title>EL Function Examples</title>
</head>
<body>
<h1>EL Function Examples</h1>
<c:set var="num" value="-500"/>
The absolute value of ${num} is ${wf:abs(num)}.<br/>

<c:set var="calc" value="${1 + 2 * 3 + 4 div 6}"/>
The rounded value of ${calc} is ${wf:round(calc)}.<br/>


</body>
</html>
