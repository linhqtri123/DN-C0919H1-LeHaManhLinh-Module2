<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04-12-2019
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sandwich Funny</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/choice" method="post">
    <input type="checkbox" name="choice" value="lettuce">Lettuce
    <input type="checkbox" name="choice" value="tomato">Tomato
    <input type="checkbox" name="choice" value="mustard">Mustard
    <input type="checkbox" name="choice" value="sprouts">Sprouts
    <button type="submit">save</button>
    <c:if test="${result!=null}">
        <p>Sandwich with ${result}</p>
    </c:if>


</form>
</body>
</html>
