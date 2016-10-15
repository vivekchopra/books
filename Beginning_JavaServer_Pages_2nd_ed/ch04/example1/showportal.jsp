<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<c:choose>
    <c:when test="${param.color == 'blue'}">
        <c:set var="selcolor" value="blue"/>
    </c:when>
    <c:when test="${param.color == 'red'}">
        <c:set var="selcolor" value="red" />
    </c:when>
    <c:when test="${param.color == 'green'}">
        <c:set var="selcolor" value="green" />
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${param.font == 'sans-serif'}">
        <c:set var="selfont" value="Verdana, Geneva, Arial, Helvetica, sans-serif"/>
    </c:when>
    <c:when test="${param.font == 'serif'}">
        <c:set var="selfont" value="'Times New Roman',Times,serif" />
    </c:when>
</c:choose>

<style>
.tableCell
{
	font-family : ${selfont};
	font-size : 16;
	font-weight : bold;
	color : #0f7fcf;
	background-color: #ffffff;
}

.valueCell
{
	font-family : ${selfont};
	font-size : 16;
	color : #000000;
	background-color: #fefefe;
}
.headLine
{
	font-family : ${selfont};
	font-size : 18;
	font-weight : bold;
	color: #000000;
}

.newsText
{
	font-family : ${selfont};
	font-size : 10;
	color: #000000;
}
.boxTitle
{
	font-family : ${selfont};
	font-size : 22;
	font-weight : bold;
	color : #ffffff;
	background-color: ${selcolor};
 
}
.mainBox
{
	font-family : ${selfont};
	font-size : 12;
    color : #ffffff;
	background-color: #eeeeee;
}

</style>

 <c:choose>
    <c:when test="${param.portchoice == 'news'}">
      <jsp:include page="news.jsp" >
           <jsp:param name="user" value="${param.username}"/>
      </jsp:include>    
    </c:when>
    <c:when test="${param.portchoice =='weather'}">
      <jsp:include page="weather.jsp" >
           <jsp:param name="user" value="${param.username}"/>
      </jsp:include>    
    </c:when>
    <c:when test="${param.portchoice == 'entertainment'}">
      <jsp:include page="entertain.jsp" >
           <jsp:param name="user" value="${param.username}"/>
      </jsp:include>    
    </c:when>
    <c:otherwise>
       <head><title>System Portal</title></head>
       <body>
       <h1>Application logic problem detected!</h1>   
       </body>
    </c:otherwise>
</c:choose>
</body>
</html>
