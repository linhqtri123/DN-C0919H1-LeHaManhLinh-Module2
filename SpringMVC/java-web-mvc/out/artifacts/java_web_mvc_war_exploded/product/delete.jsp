<%--
  Created by IntelliJ IDEA.
  User: LAptop
  Date: 11/28/2019
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

