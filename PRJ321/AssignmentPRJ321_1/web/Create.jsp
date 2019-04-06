


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <style>
            *{
                margin : 0px;
                padding : 0px;
            }

p.mess {
    text-align: center;
}

.form-group input:focus {outline: 1px solid #ff1100;outline-style: auto;border: none;}

.form-group input {
    border-radius: 5px;
    border: 1px solid gray;
    padding: 0px 5px;
    width: 60%;
    box-sizing: border-box;
}

.form-group input[type="submit"] {
    width: 100px;
    height: 30px;
    background: white;
    cursor: pointer;
}

.title {
    float: left;
    width: 30%;
    text-align: right;
    padding-right: 10%;
}

.form-group {
    margin: 10px 0px;
    width: 300px;
    padding: 0px 10px;
}
        </style>
    </head>
    <body>
        <h1>Create Product!</h1>
        <form action="MainController" action="POST">
            <div class="form-group">
                <div class="title">ID :</div>
                <input type="text" name="txtId" placeholder="Enter ID" value="${requestScope.dto.productID}"/> 
                <p class="mess" style="color:red">${requestScope.error.getProductID()}</p>
            </div>
            <div class="form-group">
                <div class="title">Name :</div>
                <input type="text" name="txtName" placeholder="Enter Name" value="${requestScope.dto.productName}"/> </br>
                <p class="mess" style="color:red">${requestScope.error.getProductName()}</p>
            </div>
            <div class="form-group">
                <div class="title">Price :</div>
                <input type="text" name="txtPrice" placeholder="Enter Price" value="${requestScope.dto.productPrice}"/> </br>
                <p class="mess" style="color:red">${requestScope.error.getProductPrice()}</p>
            </div>
            <div class="form-group">
                <div class="title">Description :</div>
                <input type="text" name="txtDescription" placeholder="Enter Description" value="${requestScope.dto.description}"/> </br>
                <p class="mess" style="color:red">${requestScope.error.getDescription()}</p>
            </div>
            <div class="form-group">
                <div class="title">Status :</div>
                <input type="text" name="txtStatus" placeholder="Enter Status" value="${requestScope.dto.status}"/> </br>
                <p class="mess" style="color:red">${requestScope.error.getStatus()}</p>
            </div>
             <div class="form-group">
                 <input type="submit" name="action" value="Create"/>
             </div>
             
            
            
        </form>
        <a href="SearchController?txtPriceMin=0&txtPriceMax=0">Back to homepage</a>
    </body>
</html>
