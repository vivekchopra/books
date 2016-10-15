<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="name" type="java.lang.String" %>
<%@attribute name="type" type="java.lang.String" %>

<c:choose>
  <c:when test="${type eq 'alphanum'}">
  if (!isTextOnly(document.prodform.${name}.value)) {
  </c:when>

  <c:when test="${type eq 'digits'}">
  if (!isDigitsOnly(document.prodform.${name}.value)) {
  </c:when>
</c:choose>
    document.getElementById("${name}Error").style.visibility = "visible";
    formValid = false;
  }
  else
    document.getElementById("${name}Error").style.visibility = "hidden";
