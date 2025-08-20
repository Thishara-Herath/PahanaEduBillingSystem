<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Edit Customer</h2>
    <form action="#" method="post">
        <input type="text" name="accountNumber" placeholder="Account Number" readonly>
        <input type="text" name="name" placeholder="Name" required>
        <input type="text" name="address" placeholder="Address" required>
        <input type="text" name="telephone" placeholder="Telephone" required>
        <button type="submit">Update</button>
    </form>
    <a href="customer_list.jsp">Back</a>
</div>
</body>
</html>