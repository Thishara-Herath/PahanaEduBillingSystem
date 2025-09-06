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
    <title>Bill Details</title>
    <!-- Styles for table -->
    <style>
        .print-btn { padding: 10px; background: #4CAF50; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
<div class="container">
    <h2>Bill #${bill.id}</h2>
    <p>Customer: ${bill.accountNumber}</p>
    <p>Date: ${bill.billDate}</p>
    <p>Units: ${bill.units}</p>
    <p>Amount: Rs. ${bill.amount}</p>
    <p>Status: ${bill.status}</p>
    <h3>Items</h3>
    <table>
        <tr><th>Item ID</th><th>Quantity</th><th>Subtotal</th></tr>
        <c:forEach var="item" items="${bill.billItems}">
            <tr>
                <td>${item.itemId}</td>
                <td>${item.quantity}</td>
                <td>${item.subtotal}</td>
            </tr>
        </c:forEach>
    </table>
    <button class="print-btn" onclick="window.print()">Print Bill</button>
    <a href="../bills/list?accNo=${bill.accountNumber}">Back to Bills</a>
</div>
</body>
</html>