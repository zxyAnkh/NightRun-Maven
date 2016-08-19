<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2016/7/7
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>城院夜跑系统</title>
</head>
<body>
{<c:forEach var="item" items="${userRunList}" varStatus="status">
    <p>"<c:out value="${status.count}"/>":
        {"id":"<c:out value="${item.uid}"/>",
        "no":"<c:out value="${item.userno}"/>",
        "name":"<c:out value="${item.username}"/>",
        "meter":"<c:out value="${item.meter}"/>",
        "time":"<c:out value="${item.time}"/>",
        "starttime":"<c:out value="${item.starttime}"/>",
        "endtime":"<c:out value="${item.endtime}"/>"}
        <c:if test="${status.count <fn:length(userRunList)}">,</c:if>
    </p>
</c:forEach>}
</body>
</html>
