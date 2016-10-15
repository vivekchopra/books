<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
  <head><title>Simple Loan Calculator</title></head>
  <body>
  <hr/>
  If you select the Payment button, this application calculates 
  the payment on a standard commercial loan 
  given: 
  <li>the amount of the loan, </li>
  <li>the annual percentage, </li>
  <li>rate and the number of monthly payments.</li>
  <br/><br/>
  If the Amount button is selected then the application shows the amount of 
  money that can be borrowed when making the specified payment each month 
  for the specified number of months at the set interest rate.
  <hr/>
  <f:view>
    <h:form id="LoanForm">
      <table border='0' >
        <tbody>
          <tr>
            <td align='right'>Loan Amount:</td>
            <td>
<%--                  <h:inputText id="amount" value="#{LoanBean.amount}"  converter="NumberToCash" >     --%>
<%--              <h:inputText id="amount" value="#{LoanBean.amount}" > --%>
              <h:inputText id="amount" value="#{LoanBean.amount}" >
                <f:convertNumber type="number" pattern="#,##0.00"/>     
                <f:valueChangeListener type="com.wrox.jsp.LogChange" />
              </h:inputText>
            </td>
          </tr>
          <tr>
            <td align='right'>Annual Percentage Rate:</td>
            <td>
              <h:inputText id="apr" value="#{LoanBean.apr}" >
                <f:validateDoubleRange minimum="0.0" maximum="25.0" />
                    <f:convertNumber type="number" />     
              </h:inputText>
            </td>
          </tr>
          <tr>
          <td align='right'>Months to Pay:</td>
          <td>
            <h:inputText id="periods" value="#{LoanBean.periods}" >
              <f:validateLongRange minimum="0" />
                  <f:convertNumber integerOnly="true"/>     
            </h:inputText>
          </td>
          </tr>
          <tr>
            <td align='right'>Payment:</td>
            <td> 
              <h:inputText id="payment" value="#{LoanBean.payment}">
                    <f:convertNumber type="number" pattern="#,##0.00"/>     
              </h:inputText>
            </td>
          </tr>
        </tbody>
      </table>
      <br/>
      <h:commandButton 
        action="#{LoanBean.amount}" value="Amount" id="AmountId" >
        <f:actionListener type="com.wrox.jsp.LogAction" />
      </h:commandButton>
      <h:commandButton 
        action="#{LoanBean.payment}" value="Payment" id="PaymentId" />
      <br/>
      <h:messages />
    </h:form>
  </f:view>
  </body>
</html>