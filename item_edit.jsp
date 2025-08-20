<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Item</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Edit Item</h2>
    <form action="#" method="post">
        <input type="text" name="id" placeholder="ID" readonly>
        <input type="text" name="name" placeholder="Name" required>
        <input type="number" name="price" placeholder="Price" step="0.01" required>
        <input type="number" name="stock" placeholder="Stock" required>
        <button type="submit">Update</button>
    </form>
    <a href="item_list.jsp">Back</a>
</div>
</body>
</html>