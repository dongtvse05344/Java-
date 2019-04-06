<%-- 
    Document   : error
    Created on : Oct 3, 2018, 1:32:18 PM
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
        <h1>Error Page !!!</h1>
        <h2 style="color:red">
            ${requestScope.ERROR}
        </h2>
        <a href="index.jsp">Back to login</a>
    </body>
</html>
