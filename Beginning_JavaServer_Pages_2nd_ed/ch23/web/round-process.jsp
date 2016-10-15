<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
-->
<c:set value="Round Management" var="title" />
<sql:setDataSource dataSource="jdbc/FootyDB" />

<sql:query var="roundExists" >
  SELECT * FROM round
  WHERE number = ? 
  <sql:param value="${param.round_number}" />
</sql:query>

<c:choose>
  <c:when test="${roundExists.rowCount != 0}">
    <sql:update>
      UPDATE round SET startdate = ?, enddate = ?
      WHERE number = ?
      <sql:param value="${param.round_startdate}" />
      <sql:param value="${param.round_enddate}" />
      <sql:param value="${param.round_number}" />
    </sql:update>
  </c:when>
  <c:otherwise>
    <sql:update>
      INSERT INTO round (number, startdate, enddate)
      VALUES (?, ?, ?)
      <sql:param value="${param.round_number}" />
      <sql:param value="${param.round_startdate}" />
      <sql:param value="${param.round_enddate}" />
    </sql:update>
  </c:otherwise>
</c:choose>
<c:redirect url="round-input.jsp" />
