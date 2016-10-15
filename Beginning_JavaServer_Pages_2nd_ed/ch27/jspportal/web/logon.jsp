<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
<head>
<title><bean:message key="welcome.title"/></title>
<html:base/>
</head>
<body bgcolor="white">
<h3><bean:message key="welcome.heading"/></h3>
<strong><font color="red">${error}</font></strong>
<strong><font color="blue">${ok_message}</font></strong>
<html:form action="/logon">
  <table width="100%" border="0">
    <tr>
      <td width="38%"><bean:message key="prompt.username"/></td>
      <td width="62%"><html:text property="username" size="16" maxlength="18"/></td>
    </tr>
    <tr>
      <td><bean:message key="prompt.password"/></td>
      <td><html:password property="password" size="16" maxlength="18"
                    redisplay="false"/>
      </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>      
	    <html:submit>
            <bean:message key="welcome.logon"/>
        </html:submit>
	  </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      
    <td>&nbsp;</td>
    </tr>
    <tr>
      <td><html:link page="/editRegistration.do"><bean:message key="welcome.newuser"/></html:link></td>
      <td>&nbsp;</td>
    </tr>
  </table>
</html:form>
</body>
</html:html>
