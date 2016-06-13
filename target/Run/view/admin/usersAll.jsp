<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 5/14/2016
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>城院夜跑系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="../../js/jquery-2.2.4.min.js" type="text/javascript"></script>
    <script src="../../js/select.js" type="text/javascript"></script>
    <script src="../../js/deleteuser.js" type="text/javascript"></script>
</head>
<body>
<%@include file="head.jsp"%>
<div class="html-editor-align-center">
    <table class="table table-striped" id="usertable">
        <thead>
        <tr>
            <th>#</th>
            <th>学号</th>
            <th>姓名</th>
            <th>年级</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${viewJsAsEntities}" var="viewJsAsEntity" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td  name="item">${viewJsAsEntity.sno}</td>
                <td>${viewJsAsEntity.sname}</td>
                <td>${viewJsAsEntity.sgrade}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
