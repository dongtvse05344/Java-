<%-- 
    Document   : index
    Created on : 26-Sep-2018, 13:25:21
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
        <h1>Book Store</h1>
        <form action="MainController" method="POST">
            Please choose your book :
            <select name="listBook">
                <option value="B001-PRJ311-123">PRJ311</option>
                <option value="B002-PRJ321-234">PRJ321</option>
                <option value="B003-PRM391-456">PRM391</option>
                <option value="B003-PRX301-567">PRX301</option>
            </select>
            <input type="submit" name="action" value="Add to cart" />
        </form>
        
        <a href="ViewToCart.jsp">View to cart</a>
    </body>
</html>
