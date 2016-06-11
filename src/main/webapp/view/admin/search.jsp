<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 5/28/2016
  Time: 4:04 PM
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
    <link rel="icon" href="../../favicon.ico">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <script type="text/javascript" src="../../js/jquery-2.2.4.min.js" charset="UTF-8"></script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="../../js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="../../css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <script src="../../js/search.js" type="text/javascript"></script>
</head>
<body>
<%@include file="head.jsp" %>
<div class="btn-toolbar right" role="toolbar">
    <div class="btn-group btn-group-sm">
        <input id="stime" size="16" type="text" value="" readonly class="form_date" onchange="timeChange()"
               placeholder="起始时间">
        <input id="etime" size="16" type="text" value="" readonly class="form_date" onchange="timeChange()"
               placeholder="终止时间">
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
</div>
<div class="html-editor-align-center" onload="searchtype()">
    <table class="table table-striped" id="runtable">
        <thead>
        <tr>
            <th>夜跑查询结果</th>
            <th>学号</th>
            <th>姓名</th>
            <th>跑步用时</th>
            <th>跑步时间(开始时间)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${runSearchResult}" var="result" varStatus="status">
            <c:if test="${runSearchResult != null}">
                <tr>
                    <td>${status.count}</td>
                    <td>${result.sno}</td>
                    <td>${result.sname}</td>
                    <td>
                        <fmt:formatNumber type="number" value="${(result.time-result.time%60)/60}"
                                          maxFractionDigits="0"/>分
                        <fmt:formatNumber type="number" value="${result.time%60}" minIntegerDigits="2"/>秒
                    </td>
                    <td>${result.starttime}</td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
    <table class="table table-striped" id="usertable">
        <thead>
        <tr>
            <th>学生查询结果</th>
            <th>学号</th>
            <th>姓名</th>
            <th>年级</th>
            <th>是否注销</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${viewJsAsEntities}" var="result" varStatus="status">
            <c:if test="${viewJsAsEntities != null}">
                <tr>
                    <td>${status.count}</td>
                    <td>${result.sno}</td>
                    <td>${result.sname}</td>
                    <td>${result.sgrade}</td>
                    <td><c:if test="${result.deltime == null}">否</c:if>
                        <c:if test="${result.deltime != null}">是</c:if>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
    <table class="table table-striped" id="totaltable">
        <thead>
        <tr>
            <th>统计查询结果</th>
            <th>学号</th>
            <th>姓名</th>
            <th>年级</th>
            <th>跑步次数</th>
            <th>跑步时长</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${viewJsTotalEntities}" var="result" varStatus="status">
            <c:if test="${viewJsTotalEntities != null}">
                <tr>
                    <td>${status.count}</td>
                    <td>${result.sno}</td>
                    <td>${result.sname}</td>
                    <td>${result.sgrade}</td>
                    <td>${result.count}</td>
                    <td>
                        <fmt:formatNumber type="number" value="${(result.sumtime-result.sumtime%60)/60}"
                                          maxFractionDigits="0"/>分
                        <fmt:formatNumber type="number" value="${result.sumtime%60}" minIntegerDigits="2"/>秒
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
