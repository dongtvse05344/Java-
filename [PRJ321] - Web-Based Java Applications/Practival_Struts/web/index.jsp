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
        <a href="search.jsp">Search</a>
        <form action="GetAllAction">
            <input type="submit" value="Get All"/>
        </form>
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
                            <a href="SetFlyFor?flightCode=<s:property value="code"/>">Set Fly</a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
    </body>
</html>
