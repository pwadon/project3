<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<h1>Users</h1>
    <table border="3">
        <tr>
            <th bgcolor="#f5f5dc">User id</th>
            <th bgcolor="#f5f5dc">User name</th>
            <th bgcolor="#f5f5dc">User details</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getUsername()}</td>
                <td><a href="/User?userid=${user.getId()}">Show User</a> </td>
            </tr>
        </c:forEach>
    </table>
<%@include file="/WEB-INF/views/footer.jsp"%>
