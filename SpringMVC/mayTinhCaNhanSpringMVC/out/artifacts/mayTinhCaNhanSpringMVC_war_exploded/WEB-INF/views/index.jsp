<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04-12-2019
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Máy tính cá nhân</title>
  </head>
  <body>
  <h1>Caculator</h1>
  <form action="/caculator" method="post">
    <input type="text" name="numberA">
    <input type="text" name="numberB">
    <br><br>
    <button name="choice" type="submit" value="sum">Cộng +</button>
    <button name="choice" type="submit" value="sub">Trừ -</button>
    <button name="choice" type="submit" value="mul">Nhân x</button>
    <button name="choice" type="submit" value="div">Chia %</button>
    <br><br>
    <c:if test="${result!=null}">
      <p>Result: ${result}</p>
    </c:if>
  </form>
  </body>
</html>
