<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="auth-check.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>
<%@ include file="auth-check.jsp" %>
<html>
<head>
    <title>Item List</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .container { max-width: 800px; margin: 20px auto; padding: 20px; background: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }
        th { background: #f2f2f2; }
        a { color: #2196F3; text-decoration: none; }
        a:hover { text-decoration: underline; }
        .btn { padding: 5px 10px; background: #4CAF50; color: white; border-radius: 4px; }
        .btn-delete { background: #f44336; }
    </style>
</head>
<body>
<div class="container">
    <h2>Items</h2>
    <a href="add" class="btn">Add New Item</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="${item.price}"/></td>
                <td><c:out value="${item.stock}"/></td>
                <td>
                    <a href="edit?id=${item.id}">Edit</a> |
                    <a href="delete?id=${item.id}" onclick="return confirm('Are you sure?');" class="btn-delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="../dashboard.jsp">Back to Dashboard</a>
</div>
</body>
</html>