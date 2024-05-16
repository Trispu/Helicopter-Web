<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page import="user.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN</title>
        <link rel="stylesheet" type="text/css" href="admin-style.css">
   


</head>
<body>
    <div class="container">
        
        <% 
            String search = request.getParameter("SearchUser");
            if (search == null) {
                search = "";
            }
            List<UserDTO> listUser = null;
            if (request.getAttribute("SEARCH_USER") != null) {
                listUser = (List) request.getAttribute("SEARCH_USER");
            } else {
                listUser = new UserDAO().getAllUser();
            }
        %>
        <h1>ADMIN PAGE</h1>
        <button onclick="window.location.href = 'Order.jsp'">Order</button>
        <button onclick="window.location.href = 'Admin.jsp'">User</button>
        <button onclick="window.location.href = 'Helicopters.jsp'">Helicopters</button>
        <form action="MainController" method="GET">
            Full Name<input type="text" name="SearchUser" value="<%= search%>">
            <input type="submit" name="action" value="SearchUser">
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Password</th>
                    <th>Role ID</th>
                    <th>Delete</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    if (listUser != null && listUser.size() > 0) {
                        int count = 1;
                        for (UserDTO user : listUser) {
                %>
                <tr>
                    <form action="MainController" method="POST">
                        <td><%= count++%></td>
                        <td><input type="text" name="userID" value="<%= user.getUserID()%>" readonly></td>
                        <td><input type="text" name="fullName" value="<%= user.getFullName()%>" required></td>
                        <td><input type="text" name="password" value="<%= user.getPassword()%>" readonly></td>
                        <td><input type="text" name="roleID" value="<%= user.getRoleID()%>" required></td>
                        <td><a href="MainController?userID=<%= user.getUserID()%>&action=DeleteUser&SearchUser=<%= search%>">Delete</a></td>
                        <td>
                            <input type="submit" name="action" value="UpdateUser">
                            <input type="hidden" name="search" value="<%= search%>">
                        </td>
                    </form>
                </tr>
                <% 
                        }
                    }
                %>
            </tbody>
        </table>
        <div>
            <% 
                String error = (String) request.getAttribute("ERROR");
                if (error == null) {
                    error = "";
                }
            %> <%= error%>
        </div>
        <p><%= error%></p>
    </div>
    <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>
</body>

</html>
                                   