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
    <title>Bill List</title>
    <!-- Styles similar to customer-list -->
</head>
<body>
<div class="container">
    <h2>Bills</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Units</th>
            <th>Amount</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="bill" items="${bills}">
            <tr>
                <td><c:out value="${bill.id}"/></td>
                <td><c:out value="${bill.billDate}"/></td>
                <td><c:out value="${bill.units}"/></td>
                <td><c:out value="${bill.amount}"/></td>
                <td><c:out value="${bill.status}"/></td>
                <td><a href="view?id=${bill.id}">View/Print</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="../dashboard.jsp">Back</a>
</div>
</body>
</html>