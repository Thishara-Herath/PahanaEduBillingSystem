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
  <title>Generate Bill</title>
  <style>
    /* Similar to customer-form */
    .item-row { display: flex; margin-bottom: 10px; }
    .item-row select, .item-row input { flex: 1; margin-right: 10px; }
  </style>
  <script>
    function addItemRow() {
      var row = document.createElement('div');
      row.className = 'item-row';
      row.innerHTML = `
                <select name="itemId">
                    <c:forEach var="item" items="${items}">
                        <option value="${item.id}">${item.name} - Rs.${item.price}</option>
                    </c:forEach>
                </select>
                <input type="number" name="quantity" placeholder="Quantity" min="1" required>
                <button type="button" onclick="this.parentNode.remove()">Remove</button>
            `;
      document.getElementById('items-container').appendChild(row);
    }
  </script>
</head>
<body>
<div class="container">
  <h2>Generate Bill</h2>
  <form action="../bills" method="post">
    <label>Customer:</label>
    <select name="accountNumber" required>
      <c:forEach var="customer" items="${customers}">
        <option value="${customer.accountNumber}">${customer.name} (${customer.accountNumber})</option>
      </c:forEach>
    </select>
    <h3>Items</h3>
    <div id="items-container"></div>
    <button type="button" onclick="addItemRow()">Add Item</button>
    <button type="submit">Generate Bill</button>
  </form>
  <a href="../dashboard.jsp">Back</a>
</div>
<script>addItemRow(); // Add first row by default</script>
</body>
</html>