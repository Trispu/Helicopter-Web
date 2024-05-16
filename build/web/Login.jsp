<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required><br>
            Password <input type="password" name="password" required><br>
            <input type="submit" name="action" value="Login">
            <input type="reset" value="Reset">
        </form>
        <div class="register-link">
            <button onclick="window.location.href='Register.jsp'">Register new Account</button>
        </div>
        <% String error = (String) request.getAttribute("ERROR");
           if (error == null) {
               error = "";
           } %>
        <div class="error-message"><%= error %></div>
    </div>
</body>
</html>
