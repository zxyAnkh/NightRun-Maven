<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 6/3/2016
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<form action="/view/admin/add" method="post" class="form-horizontal">
    <fieldset>
        <legend>添加学生</legend>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="no">学号&nbsp;&nbsp;</label>
            <div class="input-group">
                <input class="form-control" type="text" id="no" value="" name="no" />
            </div>
        </div>
        <div class="form-group form-group-sm">
            <label class="col-sm-2 control-label" for="name">姓名&nbsp;&nbsp;</label>
            <div class="input-group">
                <input class="form-control" type="text" id="name" value="" name="name""/>
            </div>
        </div>
        <div class="form-group form-group-sm">
            <button type="submit" class="btn btn-primary disabled" id="submit">确定</button>
        </div>
    </fieldset>
</form>
</body>
</html>
