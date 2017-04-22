<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/8
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<script>
    function pagenavigator(){
        $.ajax({
            type: "GET",
            url: '/ntr/admin/getUsersAllPage',
            contentType:"application/json;charset=UTF-8",
            success:function(data){
                var url = window.location.href;
                var currPage = url.substring(url.indexOf('?') + 1).substring(url.substring(url.indexOf('?') + 1).indexOf('=') + 1);
                data = JSON.parse(data);
                var page = data['page'];
                var options = {
                    currentPage: currPage,
                    totalPages: page,
                    numberOfPages: 5,
                    pageUrl: function (type, page, current) {
                        return "/ntr/admin/usersAll?page=" + page;
                    }
                };
                $('#navigator').bootstrapPaginator(options);
            }
        });
    }
</script>
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
    <script type="text/javascript" src="<%=basePath%>app/js/page.js"></script>
    <script type="text/javascript" src="<%=basePath%>app/js/bootstrap-paginator.js"></script>
</head>
<body onload="pagenavigator()">
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
            <th>是否注销</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${usersNAList}" var="user" varStatus="status">
            <c:if test="${user.deltime == null}">
                <tr>
                    <td>${status.count}</td>
                    <td name="item">
                        <a href="<%=basePath%>ntr/admin/search?type=details&keyword=${user.userno}&page=1">${user.userno}</a>
                    </td>
                    <td>${user.username}</td>
                    <td>${user.usergrade}</td>
                    <td><c:if test="${user.userbranch == 1}">计算</c:if>
                        <c:if test="${user.userbranch == 4}">医学</c:if>
                        <c:if test="${user.userbranch == 9}">法学</c:if></td>
                    <td>否</td>
                </tr>
            </c:if>
            <c:if test="${user.deltime != null}">
                <tr class="danger">
                    <td>${status.count}</td>
                    <td name="item">${user.userno}</td>
                    <td>${user.username}</td>
                    <td>${user.usergrade}</td>
                    <td><c:if test="${user.userbranch == 1}">计算</c:if></td>
                    <td>是</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
    <div class="span2" id="navigator">
        <nav>
            <ul class="pagination" id="pagenav">
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
