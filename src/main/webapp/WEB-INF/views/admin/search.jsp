<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/10
  Time: 11:02
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
    <script type="text/javascript" src="<%=basePath%>app/js/page.js"></script>
</head>
<body onload="searchType()">
<%@include file="head.jsp" %>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span2"></div>
        <div class="span8">
            <ul class="breadcrumb">
                <li id="resultAll">搜索结果<span class="divider hidden" id="resultAllSpan">/</span></li>
                <li class="active hidden" id="resultDetails">详细信息</li>
            </ul>
            <table class="table table-striped hidden" id="searchTable">
                <thead>
                <tr>
                    <th>#</th>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>年级</th>
                    <th>分院</th>
                    <th>是否注销</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${searchResult}" var="result" varStatus="status">
                    <c:if test="${searchResult != null}">
                        <c:if test="${result.deltime == null}">
                            <tr>
                                <td>${status.count}</td>
                                <td>
                                    <a href="<%=basePath%>ntr/admin/search?type=details&keyword=${result.userno}&page=1">${result.userno}</a>
                                </td>
                                <td>${result.username}</td>
                                <td>${result.usergrade}</td>
                                <td><c:if test="${result.userbranch == 1}">计算</c:if></td>
                                <td>否</td>
                            </tr>
                        </c:if>
                        <c:if test="${result.deltime != null}">
                            <tr class="danger">
                                <td>${status.count}</td>
                                <td>${result.userno}</td>
                                <td>${result.username}</td>
                                <td>${result.usergrade}</td>
                                <td><c:if test="${result.userbranch == 1}">计算</c:if></td>
                                <td>是</td>
                            </tr>
                        </c:if>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${searchDetailsTotal != null}">
                <table class="table table-striped hidden" id="detailsTable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>跑步次数</th>
                        <th>跑步用时</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>${searchDetailsTotal.userno}</td>
                        <td>${searchDetailsTotal.username}</td>
                        <td>${searchDetailsTotal.count}</td>
                        <td>
                            <fmt:formatNumber type="number"
                                              value="${(searchDetailsTotal.sumtime-searchDetailsTotal.sumtime%60)/60}"
                                              maxFractionDigits="0"/>分
                            <fmt:formatNumber type="number" value="${searchDetailsTotal.sumtime%60}"
                                              minIntegerDigits="2"/>秒
                        </td>
                    </tr>
                    </tbody>
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
                    <c:forEach items="${searchDetailsList}" var="viewRun" varStatus="status">
                        <c:if test="${searchDetailsList != null}">
                            <tr>
                                <td>${status.count}</td>
                                <td>${viewRun.userno}</td>
                                <td>${viewRun.username}</td>
                                <td>
                                    <fmt:formatNumber type="number" value="${(viewRun.time-viewRun.time%60)/60}"
                                                      maxFractionDigits="0"/>分
                                    <fmt:formatNumber type="number" value="${viewRun.time%60}" minIntegerDigits="2"/>秒
                                </td>
                                <td><fmt:formatDate value="${viewRun.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${searchDetailsTotal == null}"><div class="alert alert-danger hidden" role="alert" id="noresult">没有相关搜索结果</div></c:if>
        </div>
        <nav>
            <ul class="pagination">
                <li><a href="/ntr/admin/main?page=1">&laquo;</a></li>
                <li><a href="/ntr/admin/main?page=1">1</a></li>
                <li><a href="/ntr/admin/main?page=2">2</a></li>
                <li><a href="/ntr/admin/main?page=3">3</a></li>
                <li><a href="/ntr/admin/main?page=4">4</a></li>
                <li><a href="/ntr/admin/main?page=5">5</a></li>
                <div class="form-group">
                    <input id="pageinput" type="text" class="form-control" placeholder=""
                           onkeydown="if(event.keyCode == 13) page()">
                </div>
            </ul>
        </nav>
        <div class="span2"></div>
    </div>
</div>
</body>
</html>
