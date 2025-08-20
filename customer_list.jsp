<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Customer List</h2>
    <a href="customer_add.jsp">Add New</a>
    <table>
        <tr><th>Acc Num</th><th>Name</th><th>Address</th><th>Phone</th><th>Units</th><th>Actions</th></tr>
        <tr>
            <td>ACC001</td>
            <td>John Doe</td>
            <td>123 Main St</td>
            <td>555-1234</td>
            <td>0</td>
            <td><a href="customer_edit.jsp">Edit</a> <a href="#">Delete</a></td>
        </tr>
    </table>
    <a href="dashboard.jsp">Back</a>
</div>
</body>
</html>