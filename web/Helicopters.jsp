<%@page import="helicopters.HelicopterDAO"%>
<%@page import="java.util.List"%>
<%@page import="helicopters.HelicopterDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Helicopters</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }
            .container {
                max-width: 960px;
                margin: 20px auto;
                background-color: #fff;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
            }
            form {
                margin-bottom: 20px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                border: 1px solid #ddd;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            img {
                max-width: 90px;
                height: auto;
            }
            button {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
                border-radius: 5px;
                margin-right: 10px;
            }
            button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <% String search = request.getParameter("searchHeli");
            if (search == null) {
                search = "";
            }
            List<HelicopterDTO> listHeli = null;
            if (request.getAttribute("SEARCH_HELI") != null) {
                listHeli = (List) request.getAttribute("SEARCH_HELI");
            } else {
                listHeli = new HelicopterDAO().getAllList();
            }%>
            <h1>Helicopters</h1>
            <form action="MainController">
                <label for="searchHeli">ID or Name:</label>
                <input type="text" id="searchHeli" name="searchHeli" value="<%= search%>"/>
                <input type="submit" name="action" value="SearchHelicopter"/>
            </form>
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>HelicopterID</th>
                        <th>Helicopter Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Image</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (HelicopterDTO heli : listHeli) {
                    %>
                    <tr>
                        <td><%= count++%></td>
                        <td><input type="text" name="helicopterID" value ="<%= heli.getHelicopterID()%>" readonly/></td>
                        <td><input type="text" name="helicopterName" value ="<%= heli.getHelicopterName()%>" required/></td>
                        <td><input type="text" name="description" value ="<%= heli.getDescription()%>" required/></td>
                        <td><input type="text" name="price" value ="<%= heli.getPrice()%>" required/></td>
                        <td><img src="<%= heli.getImage()%>" alt="Image" /></td>
                        <td><a href="MainController?helicopterID=<%= heli.getHelicopterID()%>&action=DeleteHelicopter&SearchHelicopter=<%= search%>">Delete</a></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
