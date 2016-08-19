<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/8
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>城院夜跑系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="HandheldFriendly" content="True"/>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=basePath%>app/js/jquery-2.2.4.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <!-- 只有使用字体图标时才需要加载 Font-Awesome -->
    <link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="<%=basePath%>app/js/select.js" type="text/javascript"></script>
    <script src="<%=basePath%>app/js/dArUsers.js" type="text/javascript"></script>
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
            <th>分院</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${usersAList}" var="user" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td name="item">${user.userno}</td>
                <td>${user.username}</td>
                <td>${user.usergrade}</td>
                <td><c:if test="${user.userbranch == 1}">计算</c:if></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
