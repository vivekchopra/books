<%@ tag import="java.util.Random" body-content="empty" %>

<%@ attribute name="max" type="java.lang.Integer" required="true" %>
<%@ variable name-given="randomNumber" variable-class="java.lang.Integer" scope="AT_BEGIN"%>

<%
	Random rand = new Random();
	int result = rand.nextInt(max.intValue());
	jspContext.setAttribute("randomNumber", new Integer(result));
%>