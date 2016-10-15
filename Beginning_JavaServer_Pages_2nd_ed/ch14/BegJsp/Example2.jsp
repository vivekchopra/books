<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head><title>JSP Page</title></head>
<body>
  <% Random r = new Random();
     int i = r.nextInt(6)+1;
     out.println("value="+i);
  %>
</body>
</html>
