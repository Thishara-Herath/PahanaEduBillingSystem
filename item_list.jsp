<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Item List</h2>
    <a href="item_add.jsp">Add New</a>
    <table>
        <tr><th>ID</th><th>Name</th><th>Price</th><th>Stock</th><th>Actions</th></tr>
        <tr>
            <td>1</td>
            <td>Math Book</td>
            <td>$15.00</td>
            <td>50</td>
            <td><a href="item_edit.jsp">Edit</a> <a href="#">Delete</a></td>
        </tr>
    </table>
    <a href="dashboard.jsp">Back</a>
</div>
</body>
</html>