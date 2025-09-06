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
  <title>Customer Form</title>
  <style>
    /* Reuse styles from index.jsp */
    body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
    .container { max-width: 500px; margin: 50px auto; padding: 20px; background: white; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
    h2 { text-align: center; }
    form { display: flex; flex-direction: column; }
    label { margin: 10px 0 5px; }
    input { padding: 10px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 4px; }
    button { padding: 10px; background: #2196F3; color: white; border: none; border-radius: 4px; cursor: pointer; }
    button:hover { background: #1E88E5; }
  </style>
</head>
<body>

<div class="container">
  <h2>${customer == null ? 'Add Customer' : 'Edit Customer'}</h2>
  <form action="../customers" method="post">
    <input type="hidden" name="action" value="${customer == null ? 'add' : 'edit'}">
    <label>Account Number:</label>
    <input type="text" name="accountNumber" value="<c:out value='${customer.accountNumber}'/>" required ${customer != null ? 'readonly' : ''}>
    <label>Name:</label>
    <input type="text" name="name" value="<c:out value='${customer.name}'/>" required>
    <label>Address:</label>
    <input type="text" name="address" value="<c:out value='${customer.address}'/>">
    <label>Telephone:</label>
    <input type="text" name="telephone" value="<c:out value='${customer.telephone}'/>">
    <label>Units Consumed:</label>
    <input type="number" name="unitsConsumed" value="${customer.unitsConsumed}" step="0.01" required>
    <button type="submit">Save</button>
  </form>
  <a href="../customers/list">Back to List</a>
</div>
</body>
</html>