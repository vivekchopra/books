<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page errorPage="errorpg.jsp"    %>
<html>
  <head>

<sql:query var="employees" dataSource="jdbc/WroxC3P0">
select * from employee;
</sql:query>

  </head>
  <body>
    <h1>JDBC JNDI Resource Test Using C3P0</h1>
    <table width='600' border='1'> 
      <tr>
        <th align='left'>Employee ID</th>
        <th align='left'>Name</th>
        <th align='left'>Department</th>
      </tr>
<c:forEach var="employee" items="${employees.rows}">

        <tr>
          <td> ${employee.employeeid}</td>
          <td> ${employee.name} </td>
          <td> ${employee.department} </td>
        </tr>
</c:forEach>
    </table>
  </body>
</html>
