<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Embedded Java Applet </title>
</head>
<body>
<c:set var="myColor" value="${param.selcolor}"/>
<c:if test="${empty myColor}">
  <c:set var="myColor" value="0xff0000"/>
</c:if>
<h1> Embedded Java Applet</h1>
<form action="index.jsp" method="get">
<table width="500">
<tr>
<td> 
<select name="selcolor">
<option value="0xff0000">red</option>
<option value="0xffff00">yellow</option>
<option value="0x00ff88">green</option>
<option value="0x0000ff">blue</option>
</select>
  </td>
</tr>
<tr>
<td><input type="submit" value="Color it!"/></td>
</tr>
</table>
</form>
<jsp:plugin type="applet" code="com.wrox.begjsp.ch08.CircleApplet"  archive="ch08obj.jar"  >
  <jsp:params>
   <jsp:param name="radius" value="50"/>
   <jsp:param name="color" value="${myColor}"/>
  </jsp:params>

 <jsp:fallback>
    <br/>
     This browser does not support Java applets.
  </jsp:fallback>
</jsp:plugin>


</body>
</html>
