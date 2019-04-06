<%-- 
    Document   : index
    Created on : 24-Sep-2018, 15:25:30
    Author     : xhunt
--%>

<%@page import="java.util.List"%>
<%@page import="dongtv.dto.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HomePage</title>
    </head>
    <body>
        <h1>Product Manager!</h1>
        <form action="MainController" method="POST">
            Price :
            <input type="text" name="txtPriceMin" value="${requestScope.searchMin}"/> to
            <input type="text" name="txtPriceMax" value="${requestScope.searchMax}"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        
        <a href="Create.jsp">Create</a>
        
        <table cellpadding="5" border="1">
            <tr>
                <th>No</th>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Status</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
<!--            for-->
            <%
                int count =0;
            List<ProductDTO> list = (  List<ProductDTO> )request.getAttribute("data");
            if(list != null){
            for (ProductDTO dto : list) {
                    count ++;
                
            %>
            <tr>
                <td><%=count%></td>
                <td><%=dto.getProductID()%></td>
                <td><%=dto.getProductName()%></td>
                <td><%=dto.getProductPrice()%></td>
                <td><%=dto.getDescription()%></td>
                <td><%=dto.getStatus()%></td>
                <td>
                    <form action="MainController" method="post">
                        <input type="hidden" name="txtId" value="<%=dto.getProductID()%>"/>
                        <input type="hidden" name="min" value="${requestScope.searchMin}"/> 
                        <input type="hidden" name="max" value="${requestScope.searchMax}"/>
                        <input type="submit" name="action" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="MainController" method="post">
                        <input type="hidden" name="txtId" value="<%=dto.getProductID()%>"/>
                        <input type="hidden" name="txtPriceMin" value="${requestScope.searchMin}"/> 
                        <input type="hidden" name="txtPriceMax" value="${requestScope.searchMax}"/>
                        <input type="submit" name="action" value="Delete">
                    </form>
                </td>
            </tr>
            
<!--            endfor-->
            <%}}%>
        </table>
    </body>
</html>
