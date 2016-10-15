<html>
  <head>
    <title>Hello Web Application</title>
  </head>
  <body>
    <h1>Hello Web Application</h1>
    <%
      String name   = request.getParameter("name");
      if ((name == null) || (name.trim().length() == 0)) {
    %>
        You didn’t tell me your name!
    <%
      } else {
    %>
        Hello <%=name%>.
    <%
      }
    %>
    <a href="/hello/index.html">Try again?</a>
  </body>
</html>
