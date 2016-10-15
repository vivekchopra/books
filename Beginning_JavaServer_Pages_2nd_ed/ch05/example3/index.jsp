<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="newsfeed" class="com.wrox.begjsp.ch5.NewsFeed" scope="page" />


<html>
<head>
<title>EL Property Access and Nested Properties Examples</title>
</head>
<body>
<h1>EL Property Access and Nested Properties Examples</h1>

<jsp:setProperty name="newsfeed"  property="topic" value="news"/>
News headline is <b>${newsfeed.value}</b>.<br/>

<jsp:setProperty name="newsfeed"  property="topic" value="entertainment"/>
Entertainment headline is <b>${newsfeed["value"]}</b>.<br/>

<jsp:setProperty name="newsfeed"  property="topic" value="weather"/>

The weather in Tokyo right now is ${newsfeed.values.Tokyo}.<br/>
The weather in Mumbai right now is ${newsfeed["values"].Mumbai}.<br/>
The weather in Hong Kong right now is ${newsfeed.values["Hong Kong"]}.<br/>

</body>
</html>
