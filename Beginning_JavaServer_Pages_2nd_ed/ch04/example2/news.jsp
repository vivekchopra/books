<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>News Portal</title>
</head>
<body>

<script language="JavaScript" src="menu.js"></script>
<script language="JavaScript">
function showToolbar()
{
	menu = new Menu();

<c:choose>
    <c:when test="${param.menuchoice == 'news-only'}">
      menu.addItem("newsportalid", "News Portal", "News Portal", null, null);
      menu.addItem("otherportalid", "Other Portals", "Other Portals", null, null);
      menu.addSubItem("newsportalid", "World News", "World News", "http://localhost:8080/ch04/example2/","");
      menu.addSubItem("newsportalid", "American News", "American News", "http://localhost:8080/ch04/example2/","");
      menu.addSubItem("newsportalid", "UK News", "UK News", "http://localhost:8080/ch04/example2/","");

menu.addSubItem("otherportalid", "Yahoo News", "Yahoo News", "http://localhost:8080/ch04/example2/","");
menu.addSubItem("otherportalid", "CNN News", "CNN News", "http://localhost:8080/ch04/example2/","");
     </c:when>
     <c:when test="${param.menuchoice == 'all'}">
      menu.addItem("newsid", "News", "News", null, null);
      menu.addItem("weatherid", "Weather", "Weather", null, null);
      menu.addItem("entid", "Entertainment", "Entertainment", null, null);
      menu.addItem("lotid", "Lotteries", "Lottories", null, null);



      menu.addSubItem("newsid", "World News", "World News", "http://localhost:8080/ch04/example2/","");
      menu.addSubItem("newsid", "American News", "American News", "http://localhost:8080/ch04/example2/","");
      menu.addSubItem("newsid", "UK News", "UK News", "http://localhost:8080/ch04/example2/","");

menu.addSubItem("newsid", "Yahoo News", "Yahoo News", "http://localhost:8080/ch04/example2/","");
menu.addSubItem("newsid", "CNN News", "CNN News", "http://localhost:8080/ch04/example2/","");

menu.addSubItem("weatherid", "Accurate Weather", "Accurate Weather", "http://localhost:8080/ch04/example2/","");
menu.addSubItem("weatherid", "Weather Central", "Weather Central", "http://localhost:8080/ch04/example2/","");


menu.addSubItem("entid", "E Motion", "E Motion", "http://localhost:8080/ch04/example2/","");

menu.addSubItem("entid", "Hollywood on the Run", "Hollywood on the Run", "http://localhost:8080/ch04/example2/","");


menu.addSubItem("lotid", "Lucky 9", "Lucky 9", "http://localhost:8080/ch04/example2/","");

menu.addSubItem("lotid", "Mega Fortune", "Mega Fortune", "http://localhost:8080/ch04/example2/","");

     </c:when>
</c:choose>
	menu.showMenu();
}

showToolbar();
function UpdateIt(){
if (ie&&keepstatic&&!opr6)
document.all["MainTable"].style.top = document.body.scrollTop;
setTimeout("UpdateIt()", 200);
}
UpdateIt();
</script>
<br/>
<br/>

<table class="mainBox" width="600">
<tr><td class="boxTitle" >
Welcome to the News Portal, ${param.user}!
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