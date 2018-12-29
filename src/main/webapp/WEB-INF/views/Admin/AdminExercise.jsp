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

<form action="#" method="post">
    <h3>Add Group</h3>
    <input type="text" name="file" placeholder="file">
    <input type="text" name="description" placeholder="description">
    <input type="submit" name="button" value="add" >
</form>

<form action="#" method="post">
    <h3>Edit Group</h3>
    <input type="number" name="id" placeholder="group id">
    <input type="text" name="file" placeholder="file">
    <input type="text" name="description" placeholder="description">
    <input type="submit" name="button" value="edit">
</form>

<form action="#" method="post">
    <h3>Delete group</h3>
    <input type="number" name="id" placeholder="group id">
    <input type="submit" name="button" value="delete">
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>