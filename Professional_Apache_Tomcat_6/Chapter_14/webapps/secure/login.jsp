<html>
  <head><title>Please Log In</title>
  <body>
    <form method="POST" action="<%= response.encodeURL("j_security_check") %>">
      <table>
        <tr>
          <th>Username:</th>
          <td><input type="text" name="j_username"></td>
        </tr>
        <tr>
          <th>Password:</th>
          <td><input type="password" name="j_password"></td>
        </tr>
        <tr>
          <td><input type="submit" value="Log In"></td>
          <td><input type="reset"></td>
        </tr>
      </table>
    </form>
  </body>
</html>
