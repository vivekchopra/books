<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="log" uri="http://jakarta.apache.org/taglibs/log-1.0" %>
<html>
<head><title>Debugger Exercise</title></head>
<body>
<% 
    int dice = 0;
    java.util.ArrayList imageNames = new java.util.ArrayList(5);
    java.util.Random rnd = new java.util.Random();
    for (int i = 0; i < 5; i++)
    {
        dice = rnd.nextInt(6)+1;
        imageNames.add( new String("dice128_"+dice+".gif"));
    }
    pageContext.setAttribute("dice", imageNames);
%>
<table>
    <tbody align="center">
        <tr>
        <c:forEach var="imageName" items="${dice}" >
            <td><img src='${imageName}'/></td>
        </c:forEach>
        </tr>
    </tbody>
    </table>
</body>
</html>
