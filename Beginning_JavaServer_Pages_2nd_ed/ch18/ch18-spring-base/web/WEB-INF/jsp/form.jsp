<%@ taglib prefix="spring" uri="/spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
	<title><fmt:message key="form.title"/></title>
</head>
<body>

<h1><fmt:message key="form.title"/></h1>

<center>
<form method="POST">

<table width="350" border="0" cellpadding="3" cellspacing="0">
<spring:hasBindErrors name="testForm">
<tr>
	<td colspan=2><b><fmt:message key="form.error.heading"/></b></td>
</tr>
</spring:hasBindErrors>
<spring:bind path="testForm.name">
<tr>
	<td colspan=2><font color="red">${status.errorMessage}</font></td>
</tr>
<tr>
	<td><fmt:message key="form.name.title"/></td>
	<td><input type="text" name="name" value="${status.value}" size="30"></td>
</tr>
</spring:bind>
<spring:bind path="testForm.comments">
<tr>
	<td colspan=2><font color="red">${status.errorMessage}</font></td>
</tr>
<tr>
	
	<td valign="top"><fmt:message key="form.comments.title"/></td>
	<td>
	    <textarea name="comments" cols="30" rows="8">${status.value}</textarea>
	</td>
</tr>
</spring:bind>
<tr>
	<td>&nbsp;</td>
	<td align="center"><input type=submit value="submit"></td>
</tr>
</table>
</form>
</center>
</body>
</html>
