<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Select Language</title>
</head>
<body>
<h1>Please select language:</h1>
 <c:url value="application.jsp" var="engURL">
   <c:param name="locale" value="en_US"/>
 </c:url>

 <a href="${engURL}">
    <img src="english.gif"/>
 </a>
<br/>
<br/>
  <c:url value="application.jsp" var="chineseURL">
     <c:param name="locale" value="zh_HK"/>
  </c:url>

  <a href="${chineseURL}"> 
       <img src="chinese.gif"/>
  </a>
<br/>
<br/>
  <c:url value="application.jsp" var="frenchURL">
     <c:param name="locale" value="fr_FR"/>
  </c:url>

  <a href="${frenchURL}"> 
       <img src="french.gif"/>
  </a>


</body>
</html> 
