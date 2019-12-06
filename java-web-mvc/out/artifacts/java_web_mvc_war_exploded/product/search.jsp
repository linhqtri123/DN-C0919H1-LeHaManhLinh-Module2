<%--
  Created by IntelliJ IDEA.
  User: LAptop
  Date: 11/28/2019
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search product</title>
</head>
<body>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    Name Product:
    <input type="text" name="search" id="search">
    <input type="submit" value="Search">
    <table border="1">
        <tr>
            <td>Name Product</td>
            <td>Date Delivery</td>
            <td>Address Delivery</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td><a href="/products?action=view&id=${product.getId()}">${product.getNameProduct()}</a></td>
                <td>${product.getDateDeliver()}</td>
                <td>${product.getAddressDeliver()}</td>
                <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
                <td><a href="/products?action=delete&id=${product.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>