<%-- 
    Document   : index
    Created on : 21-Sep-2018, 13:11:45
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="LoginController" method="POST">
            Username : <input type="text" name="username" placeholder="Enter Username"/>
            </br>
            Password : <input type="password" name="password" placeholder="Enter Password"/>
            </br>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
