<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="auth-check.jsp" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>
<%@ include file="auth-check.jsp" %>
<html>
<head>
    <title>Pahana Edu Billing System - Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; }
        nav { background: #333; color: white; padding: 10px; }
        nav ul { list-style: none; padding: 0; display: flex; justify-content: center; }
        nav ul li { margin: 0 15px; }
        nav ul li a { color: white; text-decoration: none; }
        nav ul li a:hover { text-decoration: underline; }
        .container { max-width: 800px; margin: 20px auto; padding: 20px; background: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h1 { text-align: center; color: #333; }
    </style>
</head>
<body>
<nav>
    <ul>
        <li><a href="customers/list">Manage Customers</a></li>
        <li><a href="items/list">Manage Items</a></li>
        <li><a href="bills/generate">Generate Bill</a></li>
        <li><a href="help.jsp">Help</a></li>
        <li><a href="logout">Logout</a></li>
    </ul>
</nav>
<div class="container">
    <h1>Welcome to Pahana Edu Billing System</h1>
    <p>Use the menu to navigate.</p>
</div>
</body>
</html>