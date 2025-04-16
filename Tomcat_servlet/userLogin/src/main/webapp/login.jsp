<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
</head>
<body>
<h2>User Login</h2>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<p style="color: red;"><%= error %></p>
<%
    }
%>
<form action="login-user" method="post">
    <label>Username: <input type="text" name="username" required></label><br>
    <label>Email: <input type="email" name="email" required></label><br>
    <label>Password: <input type="password" name="password" required></label><br>
    <input type="submit" value="Login">
</form>
</body>
</html>