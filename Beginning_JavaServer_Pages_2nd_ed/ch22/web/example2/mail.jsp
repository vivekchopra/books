<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
-->
<jsp:useBean id="SERVLET_PATH" class="java.lang.String" scope="request" />
<jsp:useBean id="ERROR_MESSAGE" class="java.lang.String" scope="request" />
<jsp:useBean id="SENT_MESSAGE" class="java.lang.String" scope="request" />
<c:set value="Send an Email" var="title" />
<html>
  <head>
    <title><c:out value="${title}" /></title>
  </head>
  <body>
  <h1><c:out value="${title}" /></h1>
  <c:if test='${!empty ERROR_MESSAGE}' >
    <h4> <font color="red">${ERROR_MESSAGE}</font> </h4>
  </c:if>
  <c:if test='${!empty SENT_MESSAGE}' >
    <h4> <font color="green">${SENT_MESSAGE}</font> </h4>
  </c:if>
  <table border="1">
    <form name="email-input" action="${SERVLET_PATH}" method="POST">
      <input type="hidden" name="ACTION" value="MAIL_SEND" />
      <tr><td><b>To</b></td><td><input name="email_to" type="text" size="40" /></td></tr>
      <tr><td><b>Subject</b></td><td><input name="email_subject" type="text" size="80" /></td></tr>
      <tr><td><b>Message</b></td><td><textarea name="email_message" cols="60" rows="10" ></textarea></td></tr>
      <tr><td colspan="2" align="center" ><input name="SEND" type="submit" value="Send Email" /></td></tr>
    </form>
  </table>
  <p/>
</html>