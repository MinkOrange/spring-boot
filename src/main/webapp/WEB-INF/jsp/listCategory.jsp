<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Orange
  Date: 2018/12/13
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>遍历Category集合</title>
</head>
<body>
<table align="center" border="1" cellpadding="5">
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${cs}" var="i" varStatus="st">
        <tr>
            <td>${i.id}</td>
            <td>${i.name}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
