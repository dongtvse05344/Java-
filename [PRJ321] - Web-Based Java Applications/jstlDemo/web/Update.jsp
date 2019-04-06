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
        <h1>Update !</h1>
        <form action="MainController" method="POST">
            Username : <input type="text" name="txtUsername" readonly="true" value="${requestScope.DTO.username}"/><br/><br/>
            Password : <input type="password" name="txtPassword" value="${requestScope.DTO.password}"/><br/><br/>
             Name : <input type="text" name="txtName" value="${requestScope.DTO.fullname}"/>
            Role : <input type="text" name="txtRole" value="${requestScope.DTO.role}"/>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="action" value="Update"/>
        </form>
    </body>
</html>
