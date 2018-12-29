<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
    <h1>Groups</h1>
<table BORDER="2">
    <tr>
        <th bgcolor="#f0f8ff">group id</th>
        <th bgcolor="#f0f8ff">group name</th>
        <th bgcolor="#f0f8ff">group users</th>
    </tr>
    <c:forEach items="${userGroup}" var="group">
        <tr>
            <td>${group.getId()}</td>
            <td>${group.getName()}</td>
            <td><a href="/Users?GroupId=${group.getId()}">Show ${group.getName()} Users</a> </td>
        </tr>
    </c:forEach>
</table>

<a href="/editGroups">Edit Groups</a>
<%@include file="/WEB-INF/views/footer.jsp"%>
