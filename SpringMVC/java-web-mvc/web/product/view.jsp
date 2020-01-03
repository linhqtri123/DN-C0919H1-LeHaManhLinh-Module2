<%--
  Created by IntelliJ IDEA.
  User: LAptop
  Date: 11/28/2019
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name Product: </td>
        <td>${requestScope["product"].getNameProduct()}</td>
    </tr>
    <tr>
        <td>Date Delivery: </td>
        <td>${requestScope["product"].getDateDeliver()}</td>
    </tr>
    <tr>
        <td>Address Delivery: </td>
        <td>${requestScope["product"].getAddressDeliver()}</td>
    </tr>
</table>
</body>
</html>
