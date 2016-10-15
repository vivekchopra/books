<head>
<link rel=stylesheet type="text/css" href="portal.css">
<title>News Portal</title>
</head>
<body>
<table class="mainBox" width="600">
<tr><td class="boxTitle" >
Welcome to the News Portal!
</td></tr>
<tr><td> 
<span class="headLine">
<jsp:useBean id="newsfeed" class="com.wrox.begjsp.ch2.NewsFeed" scope="request" >
<jsp:setProperty name="newsfeed"  property="topic" value="news"/>
<jsp:getProperty name="newsfeed" property="value"/>
</jsp:useBean>
</span>
<span class="newsText">
<jsp:include page="dummytext.html" />
</span>
</td></tr>
</table>