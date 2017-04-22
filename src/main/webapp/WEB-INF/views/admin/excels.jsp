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
<script>
    function pagenavigator() {
        $.ajax({
            type: "GET",
            url: '/ntr/admin/getExcelPages',
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                var url = window.location.href;
                var currPage = url.substring(url.indexOf('?') + 1).substring(url.substring(url.indexOf('?') + 1).indexOf('=') + 1);
                data = JSON.parse(data);
                var page = data['page'];
                var options = {
                    currentPage: currPage,
                    totalPages: page,
                    numberOfPages: 5,
                    pageUrl: function (type, page, current) {
                        return "/ntr/admin/excels?page=" + page;
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
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script type="text/javascript" src="<%=basePath%>app/js/jquery-2.2.4.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>app/js/page.js"></script>
    <script type="text/javascript" src="<%=basePath%>app/js/bootstrap-paginator.js"></script>
</head>
<body onload="pagenavigator()">
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
        <div class="span2" id="navigator">
            <nav>
                <ul class="pagination" id="pagenav">
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
