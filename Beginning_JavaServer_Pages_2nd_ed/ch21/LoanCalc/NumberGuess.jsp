<!-- name NumberGuess.jsp -->
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="/taglib" prefix="t" %>
<html>
  <head><title>Number Guess</title></head>
<body>
  I am thinking of a number between 1 and 10.  Can you guess it?
  <f:view>
    <h:form id="GuessForm">
      <h:inputText id="number" value="#{GuessBean.guess}" >
        <f:validateLongRange minimum="1" maximum="10" />
      </h:inputText>
      <h:commandButton action="#{GuessBean.action}" value="Guess"/><BR/>
      <h:messages />
    </h:form>
  </f:view>
</body>
</html>
