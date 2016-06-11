<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 5/12/2016
  Time: 12:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>城院夜跑系统</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/jquery-2.2.4.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../../js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="../../css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="../../js/search.js" type="text/javascript"></script>
</head>
<body>
<%@include file="head.jsp"%>
<div class="btn-toolbar" role="toolbar">
    <div class="btn-group btn-group-sm">
        <input id="stime" size="16" type="text" value="" readonly class="form_date" onchange="timeChange()" placeholder = "起始时间">
        <input id="etime" size="16" type="text" value="" readonly class="form_date" onchange="timeChange()" placeholder = "终止时间">
    </div>
    <div class="btn-group btn-group-sm">
        <button id="time" type="button" onclick="timeQuery()" class="btn btn-primary disabled">查询</button>
    </div>
    <script type="text/javascript">
        $(".form_date").datetimepicker({
            format: 'yyyy-mm-dd',
            minView: "month",
            todayBtn: true,
            autoclose: true,
            todayHighlight: true
        });
    </script>
</div>
<div class="html-editor-align-center">
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
        <c:forEach items="${viewJsRunEntityList}" var="viewJsRunEntity" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${viewJsRunEntity.sno}</td>
                <td>${viewJsRunEntity.sname}</td>
                <td>
                    <fmt:formatNumber type="number" value="${(viewJsRunEntity.time-viewJsRunEntity.time%60)/60}"
                                      maxFractionDigits="0"/>分
                    <fmt:formatNumber type="number" value="${viewJsRunEntity.time%60}" minIntegerDigits="2"/>秒
                </td>
                <td>${viewJsRunEntity.starttime}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
