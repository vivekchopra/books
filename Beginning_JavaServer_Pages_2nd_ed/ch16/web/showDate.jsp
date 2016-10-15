<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<html>
  <head>
    <title>
      Current Date and Time
    </title>
  </head>
  <body>
    <h1>
      Date and Time
    </h1>
    The date and time is :
    <fmt:formatDate value="${now}" type="both" />
  </body>
</html>
