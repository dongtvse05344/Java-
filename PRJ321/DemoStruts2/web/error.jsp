<%-- 
    Document   : error
    Created on : 19-Oct-2018, 13:47:20
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR PAGE!</h1>
        <p style="color:red;">
            <s:property value="%{#request.ERROR}"/>
        </p>
    </body>
</html>
