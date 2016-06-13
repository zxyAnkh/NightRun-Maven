<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 6/4/2016
  Time: 7:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../../js/head.js"></script>
    <script type="text/javascript" src="../../js/search.js"></script>
</head>
<body onload="urlcheck()">
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="">管理员端</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="home"><a href="/view/admin/main">首页</a></li>
                <li id="notice"><a href="#">通知管理</a></li>
                <li id="user"><a href="/view/admin/users">用户管理</a></li>
            </ul>
            <ul class="navbar-form navbar-left">
                <div class="form-group">
                    <select class="form-control" id="type">
                        <option>全部</option>
                        <option>夜跑</option>
                        <option>用户</option>
                        <option>统计</option>
                    </select>
                    <input type="text" class="form-control" placeholder="请输入学号或姓名" id="ksearch"
                           onkeydown="if(event.keyCode == 13) find()">
                </div>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li id="admin"><a href="/view/admin/admin"> ${beanadminEntity.aname}</a></li>
                <li><a href="<c:url value="/view/admin/signout"/>">退出登录</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="btn-toolbar hidden" role="toolbar" id="userdiv">
    <div class="btn-group btn-group-sm" role="group">
        <a href="<c:url value="/view/admin/userAdd"/>" class="btn btn-primary" role="button">单独添加</a>
        <a href="<c:url value="/view/admin/usersAdd"/>" class="btn btn-primary" role="button">多个添加</a>
        <a onclick="delusers()" class="btn btn-primary hidden" role="button" id="delete">删除</a>
        <a onclick="resuser()" class="btn btn-primary hidden" role="button" id="restore">恢复</a>
        <a href="<c:url value="/view/admin/users"/>" class="btn btn-primary btn-lg hidden" role="button" id="usersall">隐藏注销学生</a>
        <a href="<c:url value="/view/admin/usersAll"/>" class="btn btn-primary btn-lg hidden" role="button" id="users">显示注销学生</a>
    </div>
</div>
</body>
</html>
