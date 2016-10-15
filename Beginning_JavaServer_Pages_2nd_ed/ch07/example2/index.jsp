<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wt" tagdir="/WEB-INF/tags/wroxtags" %>

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
