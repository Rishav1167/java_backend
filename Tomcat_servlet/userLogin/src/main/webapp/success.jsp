<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Successful</title>
</head>
<body>
<h2>Login Successful!</h2>
<p>Welcome, <strong><%= request.getAttribute("username") %></strong>!</p>
<p>Your email: <%= request.getAttribute("email") %></p>
<a href="login.jsp">Go back to log in</a>
</body>
</html>