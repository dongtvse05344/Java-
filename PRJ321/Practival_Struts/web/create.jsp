<%-- 
    Document   : create
    Created on : 30-Oct-2018, 19:26:30
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Create!</h1>
        <s:form action="CreateAction">
            <s:textfield name="code" label="Flight Code "/>
            <s:textfield name="name" label="Flight Name "/>
            <s:textfield name="color" label="Color "/>
            <s:textfield name="chairNo" label="Chair No "/>
            <s:submit value="Submit"/>
        </s:form>
    </body>
    
    <s:if test="%{exception.message.indexOf('duplicate') >=0}">
        <s:property value="code"/> is existed !!!
    </s:if>
</html>
