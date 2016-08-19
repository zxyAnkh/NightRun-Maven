<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/5
  Time: 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>app/css/login.css"/>
</head>
<body>
<div class="container">
    <form class="form-signin" action="ntr/user/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label class="sr-only">Account Number</label>
        <input type="text" name="userno" class="form-control"
                    placeholder="Account Number" autofocus=""/>
        <label class="sr-only">Password</label>
        <input type="password" name="password" class="form-control"
                    placeholder="Password"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>
</html>
