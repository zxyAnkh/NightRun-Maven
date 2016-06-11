<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 6/5/2016
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>城院夜跑系统</title>
</head>
<body>
{<c:forEach var="item" items="${list}" varStatus="status">
    <p>"<c:out value="${status.count}"/>":
       {"sid":"<c:out value="${item.sid}"/>",
        "sno":"<c:out value="${item.sno}"/>",
        "sname":"<c:out value="${item.sname}"/>",
        "meter":"<c:out value="${item.meter}"/>",
        "time":"<c:out value="${item.time}"/>",
        "starttime":"<c:out value="${item.starttime}"/>",
        "endtime":"<c:out value="${item.endtime}"/>"}
        <c:if test="${status.count < fn:length(list)}">,</c:if>
    </p>
</c:forEach>}
</body>
</html>
