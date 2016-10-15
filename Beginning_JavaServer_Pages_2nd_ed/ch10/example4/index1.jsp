<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<jsp:useBean id="errgen" class="com.wrox.begjsp.ch10.ErrorGenerator" />

<title>Error Generating page</title>
</head>
<body>
       <h1>Page to Generate Error</h1>
<table>
<tr>
  <td><h3>
<c:catch var="localerr">
${errgen.divideByZero}
</c:catch>
<c:if test="${localerr.rootCause.class eq 'class java.lang.ArithmeticException'}">
Do not divide by zero!
</c:if>
<c:if test="${localerr.rootCause.class eq 'class java.lang.ArrayIndexOutOfBoundsException'}">
Fix array index!
</c:if>
</h3></td>
</tr>
</table>


</body>
</html>
