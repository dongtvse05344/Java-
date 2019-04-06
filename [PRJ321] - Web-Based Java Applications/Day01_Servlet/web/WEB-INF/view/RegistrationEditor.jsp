<%-- 
    Document   : RegistrationEditor
    Created on : 16-Sep-2018, 10:58:45
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Edit</title>
    </head>
    <body>
        <style>
		.form-group{
			margin : 10px 0px;
		}
		
	</style>
        <p style="color:red">${errorString}</p>
        <h1>Edit Registration</h1>
	<form action="" method="POST">
		<div class="form-group">
			<per>User Name :</per>
			<input type="text" name="username" disabled value="${data.username}">
		</div>
		<div class="form-group">
			<per>Password :</per>
			<input type="text" name="password" value="${data.password}">
		</div>
		<div class="form-group">
			<per>Name :</per>
			<input type="text" name="name" value="${data.name}">
		</div>
		<div class="form-group">
			<per>Role :</per>
			<input type="text" name="role" value="${data.role}">
		</div>
                <div class="form-group">
			<input type="submit"  value="OK">
		</div>
	</form>
        <jsp:include page="_Footer.jsp"></jsp:include>
    </body>
</html>
