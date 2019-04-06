<%-- 
    Document   : Update
    Created on : 05-Oct-2018, 13:39:36
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
        <h1>Insert !</h1>
        <form action="MainController" method="POST">
            Username : <input type="text" name="txtUsername"/><br/><br/>
            Password : <input type="password" name="txtPassword" /><br/><br/>
            Name : <input type="text" name="txtName" />
            Role : <input type="text" name="txtRole"/>
            <input type="hidden" name="txtSearch"/>
            <input type="submit" name="action" value="Insert"/>
        </form>
    </body>
</html>
