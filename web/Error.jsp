<%-- 
    Document   : Error
    Created on : Apr 19, 2024, 11:08:02 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String error = (String) request.getAttribute("ERROR");
            if (error != null){
                error = "";
            }
            %>
            <%= error %>
    </body>
</html>
