<%@ page language="java" %>
<html>
  <body>
    <h1><font color="blue">Index Page Served By Tomcat6B</font></h1>
    <table align="centre" border="1">
      <tr>
        <td>Session ID</td>
        <td><%= session.getId() %></td>
      </tr>
      <tr>
        <td>Created on</td>
          <td><%= session.getCreationTime() %></td>
      </tr>
    </table>
  </body>
</html>
