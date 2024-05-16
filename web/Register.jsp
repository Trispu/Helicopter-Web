<%@page import="user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <%-- Khởi tạo đối tượng UserError từ dữ liệu truyền từ trình điều khiển --%>
    <%
        UserError userError = (UserError) request.getAttribute("USER_ERROR");
        if (userError == null) {
            userError = new UserError();
        }
    %>
    <div class="container">
        <h1>Register New Account</h1>
        <form action="MainController" method="POST">
            <div class="input-group">
                <label for="userID">User ID</label>
                <input type="text" id="userID" name="userID" required>
                <%= userError.getUserID() %>
            </div>
            <div class="input-group">
                <label for="fullName">Full Name</label>
                <input type="text" id="fullName" name="fullName" required>
                <%= userError.getFullName() %>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
                <%= userError.getPassword() %>
            </div>
            <div class="input-group">
                <label for="confirm">Confirm Password</label>
                <input type="password" id="confirm" name="confirm" required>
            </div>
            <button type="submit" name="action" value="Register">Register</button>
            <button type="reset">Reset</button>
        </form>
    </div>
</body>
</html>
