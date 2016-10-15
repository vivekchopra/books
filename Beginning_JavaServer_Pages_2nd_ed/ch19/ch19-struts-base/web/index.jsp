<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
	<title><bean:message key="form.title"/></title>
</head>
<body>

<h1><bean:message key="form.title"/></h1>

<center>
<html:form action="/test" method="POST">
	<table width="350" border="0" cellpadding="3" cellspacing="0">
	<logic:messagesPresent message="false">
	<tr>
		<td colspan=2><b><bean:message key="errors.global"/></b></td>
	</tr>
	</logic:messagesPresent>
	<logic:messagesPresent property="name">
    <tr>
	      <td colspan=2><html:errors property="name"/></td>
    </tr>
  </logic:messagesPresent>  
	<tr>
		<td><bean:message key="form.name.title"/></td>
		<td><html:text altKey="form.name.title" property="name" size="30"/></td>
	</tr>
	<tr>	
		<td valign="top"><bean:message key="form.comments.title"/></td>
		<td>
		    <html:textarea property="comments" cols="30" rows="8"></html:textarea>
		</td>
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