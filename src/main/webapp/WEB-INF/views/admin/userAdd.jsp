<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/9
  Time: 11:22
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
    <script type="text/javascript" src="<%=basePath%>app/js/useradd.js"></script>
</head>
<body>
<%@include file="head.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
                                <form class="form-horizontal" role="form" method="post" action="ntr/admin/userAdd">
                                    <div class="form-group">
                                        <label for="userno" class="col-sm-2 control-label">用户编号</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="userno" id="userno" placeholder="请输入用户编号" onchange="check()"/>
                                            <SPAN id="userno_notice" class="hidden"></SPAN>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="username" class="col-sm-2 control-label">用户姓名</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="username" id="username"
                                                   onchange="check()" placeholder="请输入用户姓名"/>
                                            <SPAN id="username_notice" class="hidden"></SPAN>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-primary disabled" id="submit">确认添加</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-3"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
