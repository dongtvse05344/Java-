<%-- 
    Document   : user
    Created on : 19-Oct-2018, 13:47:07
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
         <h1>Hello USER  <font color="blue"><s:property value="%{#session.USER}"/></font>!</h1>
    </body>
</html>
