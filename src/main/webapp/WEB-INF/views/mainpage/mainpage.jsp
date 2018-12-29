<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<h1>WELCOME TO PROGRAMING SCHOOL MAIN PAGE</h1>

<%@include file="/WEB-INF/views/header.jsp"%>

<table border="5">
    <h3> 5 Latest Solutions : </h3>
    <tr>
        <th bgcolor="gray">number</th>
        <th bgcolor="gray">solution id</th>
        <th bgcolor="gray">created</th>
        <th bgcolor="gray">updated</th>
        <th bgcolor="gray">exercise id</th>
        <th bgcolor="gray">user id</th>
        <th bgcolor="gray">details</th>
    </tr>
    <c:forEach items="${solutions}" var="solution" varStatus="sol">
        <tr>
            <td>${sol.count}</td>
            <td>${solution.getId()}</td>
            <td>${solution.getCreated()}</td>
            <td>${solution.getUpdated()}</td>
            <td>${solution.getExercise_id()}</td>
            <td>${solution.getUsers_id()}</td>
            <td><a href="/Solution?number=${solution.getId()}">solution details</a> </td>
        </tr>
    </c:forEach>
</table>


<%@include file="/WEB-INF/views/footer.jsp"%>

