<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<c:set value="Staff Roster" var="title" />
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
      
      <c:set var="user" value="${pageContext.request.remoteUser}" />
      <c:set var="workDay" value="${staffRoster[user]}" />
      
      Welcome  <b>${user}</b> <p/>
      
      <c:choose>
        <c:when test="${isAdmin}">
          <table border="1">
            <tr><th>Staff Member</th><th>Rostered Day</th></tr>
            <c:forEach items="${staffRoster}" var="staff" >
              <tr><td>${staff.key}</td><td>${staff.value}</td></tr>
            </c:forEach>
          </table>
        </c:when>
        <c:otherwise>
          <c:choose>
            <c:when test="${isBusiness}">
              You are rostered to work on <b>${workDay}</b> <p/>
            </c:when>
            <c:otherwise>
              Outside business hours, please try again later
            </c:otherwise>
          </c:choose>
        </c:otherwise>
      </c:choose>
      
      <p/><a href="../public/kill-session.jsp">Logout</a> <p/>
    </body>
  </html>
