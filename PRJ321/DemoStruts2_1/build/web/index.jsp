<%-- 
    Document   : insert
    Created on : 24-Oct-2018, 12:44:23
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
        <h1>Hello World!</h1>
        <s:form action="register">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:password name="confirm" label="Confirm Password"/>
            <s:textfield name="emailId" label="Email"/>
            <s:textfield name="phoneNo" label="Phone number"/>
            <s:submit value="Insert"/>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate') >=0 }">
            <s:property value="username"/> is existed !!! 
        </s:if>
    </body>
</html>
