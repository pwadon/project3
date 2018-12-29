<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<h1>Exercise</h1>
<table border="3">
    <tr>
        <th bgcolor="#f5f5dc">Exercise id</th>
        <th bgcolor="#f5f5dc">Exercise file</th>
        <th bgcolor="#f5f5dc">description</th>
    </tr>
    <c:forEach items="${exercises}" var="exercises">
        <tr>
            <td>${exercises.getId()}</td>
            <td>${exercises.getFile()}</td>
            <td>${exercises.getDescription()}</td>

        </tr>
    </c:forEach>
</table>
<%@include file="/WEB-INF/views/footer.jsp"%>