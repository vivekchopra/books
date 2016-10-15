<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="beginjsp" tagdir="/WEB-INF/tags" %>

<%
	HashMap values = new HashMap();
	values.put("Australia","Canberra");
	values.put("United States","Washington D.C.");
	values.put("France","Paris");
	values.put("Germany","Berlin");	
	values.put("Russia","Moscow");	
	values.put("Egypt","Cairo");	
	values.put("Denmark", "Copenhagen");
	values.put("New Zealand", "Wellington");
	values.put("Japan", "Tokyo");
	values.put("Canada", "Ottawa");
	values.put("Italy", "Rome");
	
	pageContext.setAttribute("values", values);	
%>

<beginjsp:highlighttableext title="Countries and their capitals"
                            search="ia"
					        columnOne="Country"
					        columnTwo="Capital"
		                    data="${pageScope.values}"
		                    countVar="foo">
		                       
	<jsp:attribute name="highlight">
		orange
	</jsp:attribute>
		
	<jsp:attribute name="lolight">		
		white
	</jsp:attribute>

	<jsp:attribute name="result">
		Total hits found: ${foo}
	</jsp:attribute>	
		              
</beginjsp:highlighttableext>
		              