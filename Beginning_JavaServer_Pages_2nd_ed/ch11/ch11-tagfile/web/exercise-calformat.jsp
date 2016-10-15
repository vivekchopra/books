<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="beginjsp" tagdir="/WEB-INF/tags" %>

<%
	Calendar cal = Calendar.getInstance();
	String pattern = "EEEE d MMMM yyyy G";
	
	pageContext.setAttribute("cal", cal);
	pageContext.setAttribute("pattern", pattern);
%>

<beginjsp:calformat calendar="${cal}" 
					pattern="${pattern}"/>
