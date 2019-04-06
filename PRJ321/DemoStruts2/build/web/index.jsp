<%-- 
    Document   : index
    Created on : 19-Oct-2018, 13:10:26
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Login Page!</h1>
        <s:form action="LoginAction">
            <s:textfield name="username" label="Username" />
            <s:password name="password" label="Password" />
            <s:submit value="Login"/>
        </s:form>
        <a></a>
    </body>
</html>
