<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="org.apache.struts.action.ActionMessages" %>
<head>
<title>Simple Struts Login Example</title>
</head>
<body bgcolor="white">

<html:errors property="<%=ActionMessages.GLOBAL_MESSAGE%>"/>
<br>
<html:form action="/login" method="post">
<input type="hidden" name="list" value="">
	<P>
	<html:errors property="username"/><br>
	Username: <html:text property="username"/><br>
	<P>
	<html:errors property="password"/><br>
	Password: <html:password property="password"/><br>
	<html:submit/>
</html:form>
</body>
</html>

