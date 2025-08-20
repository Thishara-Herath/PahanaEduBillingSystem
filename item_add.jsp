<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Item</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Add New Item</h2>
    <form action="#" method="post" onsubmit="return validateItem()">
        <input type="text" name="id" placeholder="ID" required>
        <input type="text" name="name" placeholder="Name" required>
        <input type="number" name="price" placeholder="Price" step="0.01" required>
        <input type="number" name="stock" placeholder="Stock" required>
        <button type="submit">Add</button>
    </form>
    <a href="item_list.jsp">Back to List</a>
</div>
<script>
    function validateItem() {
        var id = document.getElementsByName('id')[0].value;
        var name = document.getElementsByName('name')[0].value;
        var price = document.getElementsByName('price')[0].value;
        var stock = document.getElementsByName('stock')[0].value;
        if (id === '' || name === '' || price === '' || stock === '') {
            alert('All fields are required');
            return false;
        }
        if (isNaN(price) || price <= 0 || isNaN(stock) || stock < 0) {
            alert('Price must be a positive number, and Stock must be non-negative');
            return false;
        }
        return true;
    }
</script>
</body>
</html>