<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 6/4/2016
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript">
    function isExcel(inputFile) {
        var file = inputFile.value;
        if (file == "")
            document.getElementById("submit").classList = "btn btn-primary disabled";
        else {
            var type = file.substr(file.lastIndexOf('.') + 1);
            if ("xls" == type || "xlsx" == type)
                document.getElementById("submit").classList = "btn btn-primary";
            else {
                document.getElementById("submit").classList = "btn btn-primary disabled";
                inputFile.value = "";
            }
        }
    }
</script>
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
    <!-- Buttons 库的核心文件 -->
    <link rel="stylesheet" href="/css/buttons.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap-fileinput/4.3.1/css/fileinput.min.css">
    <link rel="script" href="http:// //cdn.bootcss.com/bootstrap-fileinput/4.3.1/js/fileinput.min.js">
    <!-- 只有使用字体图标时才需要加载 Font-Awesome -->
    <link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="../../js/jquery-2.2.4.min.js" type="text/javascript"></script>
</head>
<body>
<%@include file="head.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <form action="/view/admin/adds" method="post" enctype="multipart/form-data">
                <fieldset>
                    <legend>多个添加</legend>
                    <div class="form-group form-group-sm">
                        <label for="inputFile">File input</label>
                        <input type="file" id="inputFile" name="file" onchange="isExcel(this)"/>
                        <p class="help-block">Please choose your file to upload.</p>
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
