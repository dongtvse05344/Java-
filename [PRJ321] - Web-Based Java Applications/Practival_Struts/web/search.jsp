<%-- 
    Document   : index
    Created on : 29-Oct-2018, 22:43:14
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="create.jsp">Create</a>
        
        <s:form action="SearchAction">
            <s:textfield label="Name" name="searchName"/>
            <s:submit value="Search"/>
        </s:form>
        <p style="color:red"><s:property value="%{errorMess}"/></p>
        <s:if test="%{list !=null}">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Set Fly</th>
                </tr>
            <s:iterator value="%{list}" >
                    <tr>
                        <td><s:property value="code"/></td>
                        <td><s:property value="name"/></td>
                        <td>
                            <s:form action="DeleteAction">
                                <s:submit value="Delete"/>
                                <s:hidden name="searchName" value="%{searchName}"/>
                                <s:hidden name="code" value="%{code}"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
    </body>
</html>
