<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<c:set value="Private Page" var="title" />
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
    This is a private page ! <p/>
    The request is from : <b>${pageContext.request.remoteAddr}</b> <p/>
    Is the request secure ? : <b>${pageContext.request.secure}</b> <p/>

    Hello Remote User : <b>${pageContext.request.remoteUser}</b> <p/>
    
    Hello Principal : <b>${pageContext.request.userPrincipal.name}</b>
    
  </body>
</html>
