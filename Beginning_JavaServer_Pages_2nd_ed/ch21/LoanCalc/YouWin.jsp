<!-- name YouWin.jsp -->
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
  <head><title>Number Guess</title></head>
<body>
  <f:view>
    <h:form id="GuessForm">
      You Win!&nbsp
      <h:commandButton action="#{GuessBean.replay}" value="Replay"/><BR/>
    </h:form>
  </f:view>
</body>
</html>
