<%@ tag body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ variable name-given="code" variable-class="java.lang.String" scope="AT_END" %>
<%@ variable name-given="name" variable-class="java.lang.String" scope="AT_END" %>
<%@ variable name-given="comment" variable-class="java.lang.String" scope="AT_END" %>
<c:set var="code">
if ((!playLevel) &&  (retries < 3)) {
   var int = playLevel.probe();
}
</c:set>
<c:set var="name">
Joe Malone
</c:set>
<c:set var="comment">
This code can be used to determine the level of play.
</c:set>



