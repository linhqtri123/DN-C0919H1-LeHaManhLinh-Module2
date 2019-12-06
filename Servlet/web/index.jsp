<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LAptop
  Date: 11/26/2019
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
        <table align="center">
            <tr>
                <h1 align="center">Danh Sách Khách Hàng</h1>
            </tr>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Ngày Sinh</th>
                <th>Địa Chỉ</th>
            </tr>
            <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td><c:out value="${customer.getId()}"></c:out></td>
                <td><c:out value="${customer.getName()}"></c:out></td>
                <td><c:out value="${customer.getBirthday()}"></c:out></td>
                <td><c:out value="${customer.getAddress()}"></c:out></td>
            </tr>
            </c:forEach>
        </table>
</form>
</body>
</html>
