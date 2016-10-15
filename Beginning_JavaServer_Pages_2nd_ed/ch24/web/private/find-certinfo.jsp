<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
-->
<c:set value="Find Certificate Info" var="title" />
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
    <table border=1>
      <c:forEach var="cert" items="${requestScope['javax.servlet.request.X509Certificate']}" >
        <c:set var="subject" value="${cert['subjectDN']}" />
        <c:set var="expiry" value="${cert['notAfter']}" />
        <c:set var="quote" value="\"" />
        <tr>
          <td>SubjectDN</td><td>${fn:replace(subject, quote, '&amp;quot;')}</td>
        </tr>
        <tr>
          <td>Expiry</td><td>${expiry}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>