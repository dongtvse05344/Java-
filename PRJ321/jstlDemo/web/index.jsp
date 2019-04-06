<%-- 
    Document   : index
    Created on : Oct 3, 2018, 1:10:46 PM
    Author     : linh
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
        <form action="MainController" method="POST">
            Username :  <input type="text" name="txtUsername"/><br/>
            <font color="red">
                ${requestScope.INVALID.usernameError}
            </font>
            Password : <input type="password" name="txtPassword"><br/>
            <font color="red">
                ${requestScope.INVALID.passwordError}
            </font>
            <input type="submit" name="action" value="Login"/>
        </form>
            <a href="insert.jsp">Create New Account</a>
    </body>
</html>
