<%-- 
    Document   : setFly
    Created on : 29-Oct-2018, 23:06:27
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Hello <s:property value="%{dto.name}"/>!</h1>
        
            <hr/>
            <s:form action="UpdateAction" method="POST">
                <s:textfield name="code" value="%{dto.code}" label="Flight Code" readonly="true"/>
                <s:textfield name="name" value="%{dto.name}" label="Flight name"/>
                <s:textfield name="color" value="%{dto.color}" label="color"/>
                <s:textfield name="chairNo" value="%{dto.chairNo}" label="Chair No"/>
                <s:submit value="Update"/>
            </s:form>
            <hr/>
            <s:form  action="InsertFlyAction" method="POST">
                <s:textfield name="flightCode" value="%{dto.code}" readonly="" label="Flight Code"/>
                <s:textfield name="dateFly" label="Date Fly"/>
                <s:textfield name="customerNo" label="Customer Number"/>
                <s:hidden name="chairNo" value="%{dto.chairNo}"/>
                <s:submit value="Submit"/>
            </s:form>
            
    </body>
</html>
