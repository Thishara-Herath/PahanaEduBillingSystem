<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pahana Edu Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>Welcome to Pahana Edu Billing System</h1>
    <h2>Login</h2>
    <form action="LoginServlet" method="post" onsubmit="return validateLogin()"> <!-- # for static now -->
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
</div>
<script>
    function validateLogin() {
        var user = document.getElementsByName('username')[0].value;
        var pass = document.getElementsByName('password')[0].value;
        if (user === '' || pass === '') {
            alert('Username and Password are required');
            return false;
        }
        return true;
    }
</script>
</body>
</html>