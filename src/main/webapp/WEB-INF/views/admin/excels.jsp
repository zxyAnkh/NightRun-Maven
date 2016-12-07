<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 12/7/2016
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=basePath%>app/js/jquery-2.2.4.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>app/js/page.js"></script>
</head>
<body>
<%@include file="head.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2"></div>
        <div class="span8">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>文件名</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${excelList}" var="excel" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${excel}</td>
                        <td><a href="/ntr/admin/excel?name=${excel}">下载</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <nav>
            <ul class="pagination">
                <li><a href="/ntr/admin/excels?page=1">&laquo;</a></li>
                <li><a href="/ntr/admin/excels?page=1">1</a></li>
                <li><a href="/ntr/admin/excels?page=2">2</a></li>
                <li><a href="/ntr/admin/excels?page=3">3</a></li>
                <li><a href="/ntr/admin/excels?page=4">4</a></li>
                <li><a href="/ntr/admin/excels?page=5">5</a></li>
                <div class="form-group">
                    <input id="pageinput" type="text" class="form-control" placeholder=""
                           onkeydown="if(event.keyCode == 13) page()">
                </div>
            </ul>
        </nav>
        <div class="span2"></div>
    </div>
</div>
</body>
</html>
