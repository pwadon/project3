<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<h1>User</h1>
<table BORDER="2">
    <tr>
        <th bgcolor="#f5f5dc">id</th>
        <th bgcolor="#f5f5dc">username</th>
        <th bgcolor="#f5f5dc">email</th>
        <th bgcolor="#f5f5dc">group id</th>
    </tr>

    <tr>
        <td>${users.getId()}</td>
        <td>${users.getUsername()}</td>
        <td>${users.getEmail()}</td>
        <td>${users.getUser_group_id()}</td>
    </tr>
</table>

<h1>Solutions</h1>
<table border="2">
    <tr>
        <th bgcolor="#f5f5dc"> id</th>
        <th bgcolor="#f5f5dc"> created</th>
        <th bgcolor="#f5f5dc"> details</th>
    </tr>
    <c:forEach items="${solutions}" var="solution">
        <tr>
            <td>${solution.getId()}</td>
            <td>${solution.getCreated()}</td>
            <td><a href="/Solution?number=${solution.getId()}">solution details</a> </td>
        </tr>
    </c:forEach>
</table>

<%@include file="/WEB-INF/views/footer.jsp"%>
