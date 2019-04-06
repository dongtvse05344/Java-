<%-- 
    Document   : update.jsp
    Created on : 26-Oct-2018, 10:53:37
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Update</h1>
        <s:form action="UpdateAction" method="Post">
            <s:textfield name="laptopCode" value="%{dto.laptopCode}" readonly="true" label="Laptop Code"/>
            <s:textfield name="laptopName" value="%{dto.laptopName}" label="Laptop Name"/>
            <s:textfield name="price" value="%{dto.price}" label="Price"/>
            <s:textfield name="publisher" value="%{dto.publisher}" label="Publisher"/>
            <s:hidden name="searchPub" value="%{searchPub}" />
            <s:submit value="Update"/>
        </s:form>
</body>
</html>
