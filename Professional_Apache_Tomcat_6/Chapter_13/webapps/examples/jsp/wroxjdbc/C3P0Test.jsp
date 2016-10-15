<html>
  <head>
    <%@ page errorPage="errorpg.jsp" 
             import="java.sql.*, 
                     javax.sql.*, 
                     java.io.*, 
                     com.mchange.v2.c3p0.*" %>
  </head>
  <body>
    <h1>JDBC Test - Direct C3P0</h1>
    <%!    
        private static ComboPooledDataSource pool; 
        public void jspInit() {
        try {
           pool = new ComboPooledDataSource(); 
	     pool.setDriverClass( "com.mysql.jdbc.Driver" );  
           pool.setJdbcUrl( "jdbc:mysql://localhost:3306/wroxtomcat?autoReconnect=true" );               
           pool.setUser("empro"); 
           pool.setPassword("empass");
	     pool.setAcquireIncrement(3); 
           pool.setMaxPoolSize(30);
        } catch (Exception ex) {  
        // JSP init() cannot throw any exception 
          ex.printStackTrace();
      }
    }
    %>


 <%
    Connection conn = pool.getConnection();
    Statement stmt = conn.createStatement();
    ResultSet rset = stmt.executeQuery("select * from employee;");
    %>
    <table width='600' border='1'> 
      <tr> 

        <th align='left'>Employee ID</th>
        <th align='left'>Name</th>
        <th align='left'>Department</th>
      </tr>

      <%            
      while (rset.next()) {         
      %>
        <tr><td> <%= rset.getString(1)    %></td>
          <td> <%= rset.getString(2)  %></td>
          <td> <%= rset.getString(4)  %></td>
        </tr>
      <%  }
      if (stmt != null)
        stmt.close();

      conn.close();
      %>
    </table>
  </body>
</html>
