<%-- 
    Document   : Admin
    Created on : 21-Sep-2018, 13:30:22
    Author     : xhunt
--%>

<%@page import="java.util.List"%>
<%@page import="dongtv.dto.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Admin!</h1>
        <form action="SearchController" method="POST">
            Fullname : <input type="text" name="nameSearch" placeholder="Enter name"/>
            <input type="submit" name="action" value="Search"/>
        </form>
        <br>
        <%
            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("list");
        %>
        <h2>Result</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>No</th>
                <th>User Name</th>
                <th>Name</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <% 
                if(result != null)
                {
                int count = 0;
                for(RegistrationDTO dto : result)
                {
                    count++;
            %>
            <tr>
                <td><%= count%></td>
                <td><%= dto.getUsername()%></td>
                <td><%= dto.getName()%></td>
                <td><%= dto.getRole()%></td>
                <td><a href="MainController?action=Edit&username=<%= dto.getUsername()%>">EDIT</a></td>
                <td>
                    <form action="DeleteController" method="POST">
                        <input type="hidden" name="id" value="<%= dto.getUsername()%>"/>
                        <input type="hidden" name="nameSearch" value="<%= request.getParameter("nameSearch")%>"/>
                        <input type="submit" name="action" value="Delete"/>
                    </form>
                    
                </td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
