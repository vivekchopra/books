<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel=stylesheet type="text/css" href="portal.css">
<title>Weather Portal</title>
</head>
<body>
<table class="mainBox" width="600">
<tr><td class="boxTitle" >
You Get the Latest Weather, ${param.user}!
</td></tr>
<tr><td>
<jsp:useBean id="newsfeed" class="com.wrox.begjsp.ch2.NewsFeed" scope="request" >
<jsp:setProperty name="newsfeed"  property="topic" value="weather"/>
</jsp:useBean>
<table>
  <c:forEach items="${newsfeed.values}" var="row" >
    <tr><td class="tableCell" width="200">  ${row.city}  </td>
        <td> ${row.temp}</td>
    </tr>
   </c:forEach>
</table>
</td></tr>
</table>