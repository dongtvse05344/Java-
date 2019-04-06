<%-- 
    Document   : index
    Created on : 22-Oct-2018, 16:38:04
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Index</h1>
        <a href="create.jsp">Create</a>
        <s:form action="SearchAction" method="POST">
            Search :
            <s:textfield name="searchPub" label="Publisher"/>
            <s:submit value="Search"/>
            
        </s:form>
        <s:if test="%{#request.list !=null}">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Name</th>
                    <th>Prices</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <s:iterator  value="%{list}">
                    <tr>
                        <td><s:property value="%{laptopName}"/></td>
                        <td><s:property value="%{#request.price}"/></td>
                        <td>
                            <s:form action="EditAction" method="POST">
                                <s:hidden name="laptopCode" value="%{#request.laptopCode}"/>
                                <s:hidden name="searchPub" value="%{searchPub}"/>
                                <s:submit value="Edit" />
                            </s:form>
                        </td>
                        <td>
                            <s:form action="DeleteAction" method="Post">
                                <s:hidden name="laptopCode" value="%{laptopCode}"/>
                                <s:submit value="Delete"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
    </body>
</html>
