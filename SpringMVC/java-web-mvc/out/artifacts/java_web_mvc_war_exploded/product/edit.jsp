<%--
  Created by IntelliJ IDEA.
  User: LAptop
  Date: 11/28/2019
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name Product: </td>
                <td><input type="text" name="nameProduct" id="nameProduct" value="${requestScope["product"].getNameProduct()}"></td>
            </tr>
            <tr>
                <td>Date Delivery: </td>
                <td><input type="text" name="dateDeliver" id="dateDeliver" value="${requestScope["product"].getDateDeliver()}"></td>
            </tr>
            <tr>
                <td>Address Deliver: </td>
                <td><input type="text" name="addressDeliver" id="addressDeliver" value="${requestScope["product"].getAddressDeliver()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
