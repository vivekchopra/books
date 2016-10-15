<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
<head>
	<title><bean:message key="display.title"/></title>
</head>
<body>

<h1><bean:message key="display.title"/></h1>

<table cellspacing="0" cellpadding="0" border="0" width="50%" align="center">
<tr>
	<td><b><bean:message key="form.name.title"/></b></td>
	<td><bean:write name="testForm" property="name"/></td>
</tr>
<tr>
	<td><b><bean:message key="form.emailaddress.title"/></b></td>
	<td><bean:write name="testForm" property="emailAddress"/></td>
</tr>
<tr>
	<td><b><bean:message key="form.age.title"/></b></td>
	<td><bean:write name="testForm" property="age"/></td>
</tr>
<tr>
	<td><b><bean:message key="form.favsport.title"/></b></td>
	<td><bean:write name="testForm" property="favSport"/></td>
</tr>
<tr>
	<td><b><bean:message key="form.comments.title"/></b></td>
	<td><bean:write name="testForm" property="comments"/></td>
</tr>
</table>

</body>
</html>






