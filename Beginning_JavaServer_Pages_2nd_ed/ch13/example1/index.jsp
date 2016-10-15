<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Select a language</title>
</head>
<body>
<h1>Please select a language:</h1>
 <c:url value="en/application.jsp" var="engURL"/>
 <a href="${engURL}">
    <img src="english.gif"/>
 </a>
<br/>
<br/>
  <c:url value="zh/application.jsp" var="chineseURL"/>
  <a href="${chineseURL}"> 
       <img src="chinese.gif"/>
  </a>

</body>
</html> 
