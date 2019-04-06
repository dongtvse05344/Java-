<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Demo Struts 1</title>
</head>
<body>
	<form action="Login.do">
            <logic:messagesPresent>
                <html:messages id="error">
                    <ul style="color:red">
                        <li>${error}</li>
                    </ul>
                </html:messages>
            </logic:messagesPresent>
		<label for="">Username :</label>
		<input type="text" name="username"/></br>
		<label for="">Password :</label>
		<input type="password" name="password"/></br>
		<input type="submit" value="Login"/>
	</form>
        
    <a href="insert.jsp">Create new account</a>
</body>
</html>