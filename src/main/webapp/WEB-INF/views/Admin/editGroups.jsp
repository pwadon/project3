<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
</head>

<%@include file="/WEB-INF/views/header.jsp"%>
<h1>Groups</h1>
<table BORDER="2">
    <tr>
        <th bgcolor="#f0f8ff">group id</th>
        <th bgcolor="#f0f8ff">group name</th>

    </tr>
    <c:forEach items="${userGroup}" var="group">
        <tr>
            <td>${group.getId()}</td>
            <td>${group.getName()}</td>
        </tr>
    </c:forEach>
</table>

<form action="#" method="post">
    <h3>Add Group</h3>
    <input type="text" name="name" placeholder="name">
    <input type="submit" name="button" value="add" >
</form>

<form action="#" method="post">
    <h3>Edit Group</h3>
    <input type="number" name="id" placeholder="group id">
    <input type="text" name="name" placeholder="name">
    <input type="submit" name="button" value="edit">
</form>

<form action="#" method="post">
        <h3>Delete group</h3>
        <input type="number" name="id" placeholder="group id">
        <input type="submit" name="button" value="delete">
</form>

<a href="/editGroups">Edit Groups</a>

<%@include file="/WEB-INF/views/footer.jsp"%>