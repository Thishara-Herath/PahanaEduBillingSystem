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
    <title>Help</title>
    <!-- Basic styles -->
</head>
<body>
<div class="container">
    <h2>System Help</h2>
    <ul>
        <li>Login with username and password.</li>
        <li>Use menu to manage customers, items, generate bills.</li>
        <li>For bills, select customer and add items; system calculates automatically.</li>
        <li>View and print bills from list.</li>
        <li>Logout when done.</li>
    </ul>
    <a href="dashboard.jsp">Back</a>
</div>
</body>
</html>