<%-- 
    Document   : register
    Created on : 15-Sep-2018, 13:42:55
    Author     : xhunt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="" method="POST">
            <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input type="text" name="username" class="form-control"   placeholder="Username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" name="password" class="form-control"  placeholder="Password">
            </div>
            
            <div class="form-group">
                <label for="exampleInputPassword1">Confirm Password</label>
                <input type="password" name="password" class="form-control"  placeholder="Confirm password">
            </div>
            
            <div class="form-group">
                <label for="exampleInputPassword1">Name </label>
                <input type="text" name="name" class="form-control"  placeholder="Name">
            </div>
            
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
