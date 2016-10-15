<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
	<title><bean:message key="login.title"/></title>
</head>
<body>

<h1><bean:message key="login.title"/></h1>

<center>
<html:form action="/loginExe" method="POST">
	<table width="350" border="0" cellpadding="3" cellspacing="0">
	<logic:messagesPresent message="false">
	<tr>
		<td colspan=2><b><bean:message key="errors.global"/></b></td>
	</tr>
	</logic:messagesPresent>
	<logic:messagesPresent property="username">
    <tr>
	      <td colspan=2><html:errors property="username"/></td>
    </tr>
    </logic:messagesPresent>  
	<tr>
		<td><bean:message key="login.username.title"/></td>
		<td><html:text altKey="login.username.title" property="username" size="30"/></td>
	</tr>
	<logic:messagesPresent property="password">
    <tr>
	      <td colspan=2><html:errors property="password"/></td>
    </tr>
    </logic:messagesPresent> 
	<tr>
		<td><bean:message key="login.password.title"/></td>
		<td><html:password altKey="login.password.title" property="password" size="30"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td align="center"><html:submit/></td>
	</tr>
	</table>
</html:form>
</center>
</body>
</html>