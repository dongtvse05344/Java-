<%-- 
    Document   : login
    Created on : Oct 2, 2018, 9:39:18 AM
    Author     : linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
    </head>
    <body style="background: #f3f3f4">
        <%@include file="Menu.jsp" %>
        <div class="container">
            <div class="row content">
                <div class="col-md-6 box-des">
                    <h2>Welcome to <span class="main-color">Suicide Squad</span> Club</h2>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                    <small>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</small>
                </div>
                <div class="col-md-6 box-login">
                    <p class="text-danger">${requestScope.error.getMess()}</p>
                    <form action="${requestScope.ACTION}" method="POST">
                        <div class="form-group">
                            <label >Username :</label>
                            <input name="username" type="text" class="form-control"placeholder="Username">
                            <p class="text-danger">${requestScope.error.getUsername()}</p>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input name="password" type="password" class="form-control" placeholder="Password">
                            <small  class="form-text text-muted">We'll never share your password with anyone else.</small>
                            <p class="text-danger">${requestScope.error.getPassword()}</p>
                        </div>
                        <input type="submit" name="action" value="Login" class="btn btn-primary"/>
                        <small class="form-text text-muted">You dont have acount ? </small>
                        <a href="Register.jsp">Register</a> 
                    </form>
                </div>
            </div>
        </div>

        <script src="js/jquery-3.2.1.slim.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
