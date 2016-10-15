<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<c:set value="Show Session Information" var="title" />
<html>
  <head>
    <title>
      <c:out value="${title}" />
    </title>
  </head>
  <body>
    <h1>
      <c:out value="${title}" />
    </h1>
    The current session is : <b>${pageContext.request.session.id}</b> <p/>

    <a href="kill-session.jsp">Logout</a> <p/>
    <a href="../index.html">Back to index page</a>    
    
  </body>
</html>
