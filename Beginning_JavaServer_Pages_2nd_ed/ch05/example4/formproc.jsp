<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>EL Implicit Object Example Form Processor</title>
</head>
<body>
<h1>EL Implicit Object Example Form processor</h1>

<b>Shape of cake selected:</b> ${param.shape}<br/>
<b>Toppings selected:</b> 

<c:forEach var="aTopping" items="${paramValues.topping}">
 &nbsp;&nbsp;${aTopping}&nbsp;&nbsp;
</c:forEach>
<br/>

<b>Browser:</b> ${header["user-agent"]}<br/>

<br/>
<small><a href="index.jsp">back to form</a></small>
</body>
</html>
