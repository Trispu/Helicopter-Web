<%@page import="helicopters.HelicopterDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="helicopters.HelicopterDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER</title>
        <link rel="stylesheet" type="text/css" href="user-style.css">

        <% List<HelicopterDTO> listHeli = null;
            listHeli = new HelicopterDAO().getAllList(); %>
    <div class="container">
    </head>
    <body>

        <h2>Available Helicopters</h2>
        <table>
            <thead>
                <tr>
                    <th>No</th>
                    <th>Helicopter ID</th>
                    <th>Helicopter Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (HelicopterDTO heli : listHeli) {
                %>
                <tr>
                    <td><%= count++%></td>
                    <td><input type="text" name="helicopterID" value="<%= heli.getHelicopterID()%>" required></td>
                    <td><input type="text" name="helicopterName" value="<%= heli.getHelicopterName()%>" required></td>
                    <td><input type="text" name="description" value="<%= heli.getDescription()%>" required></td>
                    <td><input type="text" name="price" value="<%= heli.getPrice()%>" required></td>
                    <td><img src="<%= heli.getImage()%>" alt="Image" width="90" height="90"></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>

</div>

</body>
</html>
