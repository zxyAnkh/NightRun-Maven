<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/7
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="<%=basePath%>app/js/head.js"></script>
    <script type="text/javascript" src="<%=basePath%>app/js/search.js"></script>
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
            <a class="navbar-brand" href="ntr/admin/main?page=1">管理员端</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="home"><a href="ntr/admin/main?page=1">首页</a></li>
                <li class="dropdown" id="user">
                    <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" id="ahref">用户管理<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ntr/admin/users?page=1">查看活跃用户</a></li>
                        <li><a href="ntr/admin/usersAll?page=1">查看注销用户</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="ntr/admin/userAdd">单独添加用户</a></li>
                        <li><a href="ntr/admin/usersAdd">批量添加用户</a></li>
                        <li role="separator" class="divider"></li>
                        <li id="liDel"><a href="ntr/admin/users?page=1" onclick="delusers()">注销用户</a></li>
                        <li id="liRes"><a href="ntr/admin/usersAll?page=1" onclick="resuser()">恢复用户</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入学号或姓名" id="search"
                           onkeydown="if(event.keyCode == 13) find()">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </div>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li id="admin"><a href="ntr/admin/info">${userInfo.username}</a></li>
                <li><a href="<c:url value="ntr/user/logout"/>">退出登录</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
</body>
</html>