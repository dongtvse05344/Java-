<%-- 
    Document   : ViewToCart
    Created on : Sep 28, 2018, 12:59:48 PM
    Author     : linh
--%>

<%@page import="dongtv.dto.BookDTO"%>
<%@page import="dongtv.model.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
            CartObj shoppingCart = (CartObj)session.getAttribute("Cart");
        %>
        <h1><%= shoppingCart.getCustomerName()%>'s cart</h1>
        
        <form action="MainController">
            <input type="submit" name="action" value="Remove"/>
            <input type="submit" name="action" value="Update"/>
        <table border="1" cellpadding="5">
            <tr>
                <th>No</th>
                <th>Book Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Remove</th>
            </tr>
            <%
            int count =0;
            for ( BookDTO dto : shoppingCart.getCart().values()) {
                    count++;
                
            %>
            <tr>
                <td><%= count%></td>
                <td><%= dto.getName()%></td>
                <td><%= dto.getPrice()%></td>
                <td>
                    <input value="<%= dto.getQuantity()%>"/>
                </td>
                <td><input type="checkbox" value="<%= dto.getId()%>" name="checkRemove"/></td>
            </tr>
            <%}%>
        </table>
        <a href="index.jsp">Back to home</a>
        </form>
    </body>
</html>
