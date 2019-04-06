<%-- 
    Document   : insert
    Created on : 17-Oct-2018, 12:41:54
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert new Account</h1>
        <logic:messagesPresent>
            <html:messages id="error">
                <font color="red">
                <ul>
                    <li>${error}</li>
                </ul>
                </font>
            </html:messages>
        </logic:messagesPresent>
                
        <html:form action="/Insert" onsubmit="return validateInsertDynaActionForm(this);">
            Username : <html:text property="username"/> <br>
            Password : <html:password property="password"/> <br>
            Email : <html:text property="emailID"/> <br>
            PhoneNo (Ex : 090-1234567): <html:text property="phoneNo"/> <br>
            <html:submit value="Create"/>
        </html:form>
        <html:javascript formName="InsertDynaActionForm"/>
        
    </body>
</html>
