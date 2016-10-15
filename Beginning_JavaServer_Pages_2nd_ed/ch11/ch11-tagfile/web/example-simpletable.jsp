<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="beginjsp" tagdir="/WEB-INF/tags" %>

<%
  HashMap values = new HashMap();
  values.put("Australia","Canberra");
  values.put("United States","Washington DC");
  values.put("France","Paris");
  values.put("Germany","Berlin");	
  values.put("Russia","Moscow");	
  values.put("Egypt","Cairo");	

  pageContext.setAttribute("values", values);	
%>

<beginjsp:simpletable title="Countries and their capitals" 
					  columnOne="Country"
					  columnTwo="Capital"
		              data="${pageScope.values}"/>
<P>
<beginjsp:simpletable title="Request Parameters" data="${param}"/>
