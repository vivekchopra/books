<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title><fmt:message key="datalist.title"/></title>
</head>
<body>

<h1><fmt:message key="datalist.title"/></h1>

<a href="form.htm">Back to Form</a>
<p>

<table cellspacing="0" cellpadding="0" border="1" width="60%">
<tr>
  <td></td>
  <td><b><fmt:message key="datalist.colheading.name"/></b></td>
  <td><b><fmt:message key="datalist.colheading.age"/></b></td>
  <td><b><fmt:message key="datalist.colheading.comments"/></b></td>
</tr>
<c:forEach items="${requestScope.dataList}" var="thisElement" varStatus="status">
  <tr>
    <td>${status.count}</td>
    <td>${thisElement.name}</td>
    <td>${thisElement.age}</td>
    <td>${thisElement.comments}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>