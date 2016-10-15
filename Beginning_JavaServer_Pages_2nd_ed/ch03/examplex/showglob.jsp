<%@ page language="java" 
import = "com.wrox.begjsp.ch03.*,java.util.*" %>
<html>
<head>
<title>Show Application Scope</title>
</head>
<body>
<table width="600">
<tr>
<td>
<%
   
   ArrayList cats = (ArrayList) application.getAttribute("cats");
   for (int i=0; i< cats.size(); i++) {
          Category curCat = (Category) cats.get(i);
%>
         <%=  curCat.getName()  %>
<br/>
<%
    }
%>
</td>
</tr>
</table>


</body>
</html>
