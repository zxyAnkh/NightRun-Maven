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
</head>
<body>
<%@include file="head.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <form method="post" enctype="multipart/form-data">
                <fieldset>
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
