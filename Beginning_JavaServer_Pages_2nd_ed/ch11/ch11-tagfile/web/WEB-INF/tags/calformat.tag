<%@ tag body-content="empty" 
		import="java.util.Calendar,java.text.SimpleDateFormat" %>
		
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="calendar" required="true" type="java.util.Calendar" %>
<%@ attribute name="pattern" required="true" %>

<%
	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	String result = formatter.format(calendar.getTime());
	out.println(result);	
%>

