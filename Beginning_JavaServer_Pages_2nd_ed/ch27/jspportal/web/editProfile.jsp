<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/app.tld"    prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<app:checkLogon/>

<html:html>
<head>
  <title><bean:message key="registration.title.edit"/></title>
<html:base/>
</head>
<body bgcolor="white">

<html:errors/>

<html:form action="/saveProfile">
<html:hidden property="action"/>
<table border="0" width="100%">

  <tr>
	<th align="right">
	  <bean:message key="registration.username"/>:
	</th>
	<td align="left">
	  	<html:hidden property="userName" write="true"/>
	</td>
  </tr>

  <tr>
	<th align="right">
	  <bean:message key="registration.password"/>:
	</th>
	<td align="left">
	  <html:password property="password" size="16" maxlength="16"/>
	</td>
  </tr>

  <tr>
	<th align="right">
	  <bean:message key="registration.displayName"/>:
	</th>
	<td align="left">
	  <html:text property="displayName" size="50"/>
	</td>
  </tr>
  
  <tr>
	<th align="right">
	  <bean:message key="registration.interests"/>:
	</th>
	<td align="left">
	  <html:text property="interests" size="50"/>
	</td>
  </tr>
  
  <tr>
	<th align="right">
	  <bean:message key="registration.subscription"/>:
	</th>
	<td align="left">
	  <html:select property="subscriptions" multiple="true">
		 <c:forEach items="${publisher_info}" var="a_publisher">
			 <jsp:useBean id="a_publisher" type="com.wrox.begjsp.ch27.dto.Publisher"/>
			 <html:option value="${a_publisher.feedUrl}">[${a_publisher.name}] ${a_publisher.description}</html:option>
		</c:forEach>
	  </html:select>
	</td>
  </tr>

  <tr>
	<td align="right">
	  <html:submit>
		<bean:message key="button.save"/>
	  </html:submit>
	</td>
	<td align="left">
	  <html:reset>
		<bean:message key="button.reset"/>
	  </html:reset>
	</td>
  </tr>

</table>
</html:form>

</body>
</html:html>
