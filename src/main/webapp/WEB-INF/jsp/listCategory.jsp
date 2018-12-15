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
<div align="center">

</div>

<div style="width: 500px;margin: 20px auto;text-align: center">
    <table align="center" border="1" cellpadding="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.content}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="/editCategory?id=${c.id}">编辑</a> </td>
                <td><a href="/deleteCategory?id=${c.id}">删除</a> </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <a href="?start=0">[首页]</a>
        <a href="?start=${page.number-1}">[上一页]</a>
        <a href="?start=${page.number+1}">[下一页]</a>
        <a href="?start=${page.totalPages-1}">[末页]</a>
    </div>
    <br>
    <form action="/addCategory" method="post">
        name:<input name="name"> <br>
        <button type="submit">提交</button>
    </form>
</div>

</body>
</html>
