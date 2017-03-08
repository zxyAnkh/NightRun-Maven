<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/6
  Time: 11:36
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
    function pagenavigator(){
        $.ajax({
            type: "POST",
            url: '/ntr/admin/getRunPage',
            contentType:"application/json;charset=UTF-8",
            success:function(data){
                data = JSON.parse(data);
                var page = data['page'];
                var pagenav = $("#pagenav");
                for(var i = 1; i <= page;i++){
                    var li = '<li><a href="/ntr/admin/main?page='+i+'">'+i+'</a></li>';
                    pagenav.append(li);
                }
                pagenav.append('<div class="form-group"><input id="pageinput" type="text" class="form-control" placeholder="" onkeydown="if(event.keyCode == 13) page()"></div>');
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
                    <th>学号</th>
                    <th>姓名</th>
                    <th>跑步用时</th>
                    <th>跑步时间(开始时间)</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${viewRunList}" var="viewRun" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${viewRun.userno}</td>
                        <td>${viewRun.username}</td>
                        <td>
                            <fmt:formatNumber type="number" value="${(viewRun.time-viewRun.time%60)/60}"
                                              maxFractionDigits="0"/>分
                            <fmt:formatNumber type="number" value="${viewRun.time%60}" minIntegerDigits="2"/>秒
                        </td>
                        <td><fmt:formatDate value="${viewRun.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <nav>
            <ul class="pagination" id="pagenav">
            </ul>
        </nav>
        <div class="span2"></div>
    </div>
</div>
</body>
</html>
