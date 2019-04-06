<%-- 
    Document   : index
    Created on : 08-Oct-2018, 13:06:02
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
        <%
            int[] foo = {42,420,42000};
            request.setAttribute("foo", foo);
        %>
        <h1>${true or false}</h1>
    </body>
</html>
