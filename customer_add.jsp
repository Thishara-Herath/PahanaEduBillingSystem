<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Add New Customer</h2>
    <form action="CustomerServlet?action=add" method="post" onsubmit="return validateCustomer()">
        <input type="text" name="accountNumber" placeholder="Account Number" required>
        <input type="text" name="name" placeholder="Name" required>
        <input type="text" name="address" placeholder="Address" required>
        <input type="text" name="telephone" placeholder="Telephone" required>
        <button type="submit">Add</button>
    </form>
    <a href="customer_list.jsp">Back to List</a>
</div>
<script>
    function validateCustomer() {
        var accNum = document.getElementsByName('accountNumber')[0].value;
        var name = document.getElementsByName('name')[0].value;
        var addr = document.getElementsByName('address')[0].value;
        var tel = document.getElementsByName('telephone')[0].value;
        if (accNum === '' || name === '' || addr === '' || tel === '') {
            alert('All fields are required');
            return false;
        }
        if (isNaN(tel) || tel.length < 10) {
            alert('Telephone must be a valid number with at least 10 digits');
            return false;
        }
        return true;
    }
</script>
</body>
</html>