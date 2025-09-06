<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
    <title>Item Form</title>
    <style>
        /* Reuse styles from customer-form.jsp */
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .container { max-width: 500px; margin: 50px auto; padding: 20px; background: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { text-align: center; }
        form { display: flex; flex-direction: column; }
        label { margin: 10px 0 5px; }
        input, textarea { padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 4px; }
        button { padding: 10px; background: #2196F3; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #1E88E5; }
    </style>
</head>
<body>
<div class="container">
    <h2>${item == null ? 'Add Item' : 'Edit Item'}</h2>
    <form action="../items" method="post">
        <input type="hidden" name="action" value="${item == null ? 'add' : 'edit'}">
        <input type="hidden" name="id" value="<c:out value='${item.id}'/>">
        <label>Name:</label>
        <input type="text" name="name" value="<c:out value='${item.name}'/>" required>
        <label>Description:</label>
        <textarea name="description"><c:out value='${item.description}'/></textarea>
        <label>Price:</label>
        <input type="number" name="price" value="${item.price}" step="0.01" required>
        <label>Stock:</label>
        <input type="number" name="stock" value="${item.stock}" required>
        <button type="submit">Save</button>
    </form>
    <a href="../items/list">Back to List</a>
</div>
</body>
</html>