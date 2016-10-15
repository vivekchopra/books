<html>
<head>
<title>The News</title>
</head>
<body>
        <h1> Latest News</h1>
<table>
<tr>
  <td><h3><%@include file="items/news1.jsp" %></h3></td>
</tr>
<tr>
  <td><h3><jsp:include page="items/news1.jsp"/></h3></td>
</tr>
<tr> 
  <td><h3><jsp:include page="items/news3.jsp">
               <jsp:param name="survivor" value="shark"/>
           </jsp:include>
          </h3></td>
</tr>
</table>

</body>
</html>
