<%-- 
    Document   : admin
    Created on : 19-Oct-2018, 13:47:13
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Hello ADMIN  <font color="blue"><s:property value="%{#session.USER}"/></font>!</h1>
        <h2>Search</h2>
        <s:form action="SearchAction">
            <s:textfield name="txtSearch" label="Fullname"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{listQues !=null}">
            <table border="1" cellpadding="5">
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Chapter</th>
                    <th>Question</th>
                    <th>Used</th>
                    <th>Link</th>
                    <th>Submit</th>
                </tr>
                <s:iterator value="listQues" status="counter">
                    <tr>
                        <td><s:property value="%{#counter.count}"/></td>
                        <td><s:property value="name"/></td>
                        <td><s:property value="chap"/></td>
                        <td><s:property value="ques"/></td>
                        <td>
                            <s:checkbox name="used" value="%{used}" theme="simple"/>
                        </td>
                        <td>
                            <s:url action="DeleteAction" id="DeleteLink">
                                <s:param name="id" value="%{id}"/>
                                <s:param name="lastSearchValue" value="%{txtSearch}"/>
                            </s:url>
                            <s:a href="%{DeleteLink}">Delete</s:a>
                        </td>
                        <td>
                            <s:form action="DeleteAction" method="POST">
                                <s:hidden name="id" value="%{id}"/>
                                <s:hidden name="lastSearchValue" value="%{txtSearch}"/>
                                <s:submit value="Delete"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
    </body>
</html>
