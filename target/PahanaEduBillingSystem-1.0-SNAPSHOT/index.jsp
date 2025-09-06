<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Pahana Edu Billing System - Login</title>
  <style>
    body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }
    .container { max-width: 400px; margin: 100px auto; padding: 20px; background: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
    h2 { text-align: center; color: #333; }
    form { display: flex; flex-direction: column; }
    label { margin: 10px 0 5px; }
    input { padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 4px; }
    button { padding: 10px; background: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }
    button:hover { background: #45a049; }
    .error { color: red; text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h2>Login</h2>
  <% if (request.getAttribute("error") != null) { %>
  <p class="error"><%= request.getAttribute("error") %></p>
  <% } %>
  <form action="login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <button type="submit">Login</button>
  </form>
</div>
</body>
</html>