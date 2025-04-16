<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
<h2>Registration Successful!</h2>
<p>Welcome, <strong><%= request.getAttribute("username") %></strong>!</p>
<p>Your email: <%= request.getAttribute("email") %></p>
<a href="register.jsp">Go back to registration</a>
</body>
</html>