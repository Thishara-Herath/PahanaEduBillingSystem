<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate Bill</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h2>Calculate Bill</h2>
    <form action="#" method="post" onsubmit="return validateBill()">
        <select name="accountNumber" required>
            <option value="">Select Customer</option>
            <option value="ACC001">John Doe (ACC001)</option>
        </select>
        <select name="itemId" required>
            <option value="">Select Item</option>
            <option value="1">Math Book ($15, Stock: 50)</option>
        </select>
        <input type="number" name="units" placeholder="Units" required min="1">
        <button type="submit">Calculate & Save</button>
    </form>
    <a href="dashboard.jsp">Back</a>
</div>
<script>
    function validateBill() {
        var accNum = document.getElementsByName('accountNumber')[0].value;
        var itemId = document.getElementsByName('itemId')[0].value;
        var units = document.getElementsByName('units')[0].value;
        if (accNum === '' || itemId === '' || units === '') {
            alert('All fields are required');
            return false;
        }
        if (isNaN(units) || units <= 0) {
            alert('Units must be a positive number');
            return false;
        }
        return true;
    }
</script>
</body>
</html>