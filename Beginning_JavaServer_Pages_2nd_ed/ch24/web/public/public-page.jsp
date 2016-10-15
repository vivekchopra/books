<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<c:set value="Public Page" var="title" />
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
    This is a public page ! <p/>
    The request is from : <b>${pageContext.request.remoteAddr}</b> <p/>
    Is the request secure ? : <b>${pageContext.request.secure}</b>
    
  </body>
</html>
