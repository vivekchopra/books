
<html>
<head>
</head>
<body>
 <c:choose>
    <c:when test="${param.pg == 'mine'}">
        <wt:myPage/>
    </c:when>
    <c:otherwise>
        <wt:yourPage/>
    </c:otherwise>
</c:choose>
</body>
</html>
