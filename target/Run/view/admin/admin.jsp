<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 5/30/2016
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>城院夜跑系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="HandheldFriendly" content="True"/>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="../../js/jquery-2.2.4.min.js" type="text/javascript"></script>
    <script src="../../js/modify.js" type="text/javascript"></script>
</head>
<body onload="check()">
<%@include file="head.jsp"%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <form action="/view/admin/modify" method="post" class="form-horizontal">
                <fieldset>
                    <legend>管理员个人信息</legend>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="no">管理员编号&nbsp;&nbsp;</label>
                        <div class="input-group">
                            <input class="form-control" type="text" id="no" value="${beanadminEntity.ano}" name="no" readonly/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="name">管理员名字&nbsp;&nbsp;</label>
                        <div class="input-group">
                            <input class="form-control" type="text" id="name" value="${beanadminEntity.aname}" name="name" onchange="check()"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <label class="col-sm-2 control-label" for="oldpwd">管理员密码&nbsp;&nbsp;</label>
                        <div class="input-group">
                            <input class="form-control" type="password" id="oldpwd" name="oldpwd" value="${beanadminEntity.apwd}" onfocus="show()"  onchange="check()"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm hidden" id="newpwd">
                        <label class="col-sm-2 control-label" for="newpwd1">
                            &nbsp;&nbsp;新密码&nbsp;&nbsp;</label>
                        <div class="input-group">
                            <input class="form-control" type="password" id="newpwd1" value=""  name="newpwd1" onchange="check()"/>
                        </div>
                        <label class="col-sm-2 control-label" for="newpwd2">
                            &nbsp;确认密码&nbsp;&nbsp;</label>
                        <div class="input-group">
                            <input class="form-control" type="password" id="newpwd2" value=""  name="newpwd2" onchange="check()"/>
                        </div>
                    </div>
                    <div class="form-group form-group-sm">
                        <button type="submit" class="btn btn-primary disabled" id="submit">确定</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>
