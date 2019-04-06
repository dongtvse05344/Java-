<%-- 
    Document   : create
    Created on : 22-Oct-2018, 17:22:22
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
         <h1>Create</h1>
        <s:form action="CreateAction" method="POST">
            <s:textfield name="laptopCode" label="Laptop Code"/>
            <s:textfield name="laptopName" label="Laptop Name"/>
            <s:textfield name="price" label="Price"/>
            <select name="publisher">
                <option value="Dell">DELL</option>
                <option value="Asus">Asus</option>
                <option value="HP">HP</option>
                <option value="MSI">MSI</option>
            </select>
            <s:submit value="Create"/>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate') >=0 }">
            <s:property value="laptopCode"/> is existed !!! 
        </s:if>
    </body>
</html>
