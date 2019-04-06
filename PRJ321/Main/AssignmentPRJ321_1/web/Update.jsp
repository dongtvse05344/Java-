


<%@page import="dongtv.dto.ProductDTO"%>
<%@page import="dongtv.dto.ErrorObj"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
        <style>
            *{
                margin : 0px;
                padding : 0px;
            }

.form-group input:focus {outline: 1px solid #ff1100;outline-style: auto;border: none;}

.form-group input {
    border-radius: 5px;
    border: 1px solid gray;
    padding: 0px 5px;
}

.form-group input[type="submit"] {
    width: 100px;
    height: 30px;
    background: white;
    cursor: pointer;
}

.title {
    float: left;
    width: 90px;
    text-align: right;
    padding-right: 10px;
}

.form-group {
    margin: 10px 0px;
    width: 500px;
    padding: 0px 10px;
}
        </style>
    </head>
    <body>
        <h1>Update Product!</h1>
        <%
            ErrorObj error = (ErrorObj)request.getAttribute("error");
            if(error == null) error = new ErrorObj();
            ProductDTO dto = (ProductDTO) request.getAttribute("dto");
            if(dto == null) dto = new ProductDTO("", "", 0, "", "");
            String txtPriceMin = request.getParameter("txtPriceMin");
            String txtPriceMax = request.getParameter("txtPriceMax");
        %>
        
        <form action="MainController" method="POST">
            <div class="form-group">
                <div class="title">ID :</div>
                <input readonly="" type="text" name="txtId" placeholder="Enter ID" value="<%=dto.getProductID() %>"/> 
                <p class="mess" style="color:red"><%= error.getProductID()%></p>
            </div>
            <div class="form-group">
                <div class="title">Name :</div>
                <input type="text" name="txtName" placeholder="Enter Name" value="<%=dto.getProductName()%>"/> </br>
                <p class="mess" style="color:red"><%= error.getProductName()%></p>
            </div>
            <div class="form-group">
                <div class="title">Price :</div>
                <input type="text" name="txtPrice" placeholder="Enter Price" value="<%=dto.getProductPrice()%>"/> </br>
                <p class="mess" style="color:red"><%= error.getProductPrice()%></p>
            </div>
            <div class="form-group">
                <div class="title">Description :</div>
                <input type="text" name="txtDescription" placeholder="Enter Description" value="<%=dto.getDescription()%>"/> </br>
                <p class="mess" style="color:red"><%= error.getDescription()%></p>
            </div>
            <div class="form-group">
                <div class="title">Status :</div>
                <input type="text" name="txtStatus" placeholder="Enter Status" value="<%=dto.getStatus()%>"/> </br>
                <p class="mess" style="color:red"><%= error.getStatus()%></p>
            </div>
             <div class="form-group">
                 <input type="hidden" name="txtPriceMin" value="<%=txtPriceMin%>"/> </br>
                 <input type="hidden" name="txtPriceMax" value="<%=txtPriceMax%>"/> </br>
                 <input type="submit" name="action" value="Update"/>
             </div>
        </form>
        <a href="SearchController?txtPriceMin=0&txtPriceMax=0">Back to homepage</a>
    </body>
</html>
