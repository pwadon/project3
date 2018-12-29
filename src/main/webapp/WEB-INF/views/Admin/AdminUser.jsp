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
        <th bgcolor="#f5f5dc">user id</th>
        <th bgcolor="#f5f5dc">user name</th>
        <th bgcolor="#f5f5dc">email</th>
        <th bgcolor="#f5f5dc">user group id</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getUser_group_id()}</td>
        </tr>
    </c:forEach>
</table>

<form action="#" method="post">
    <h3>Add Useer</h3>
    <input type="text" name="name" placeholder="name">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="pass" placeholder="password">
    <input type="number" name="usergroupid" placeholder="user_group_id">
    <input type="submit" name="button" value="add" >
</form>

<form action="#" method="post">
    <h3>Edit User</h3>
    <input type="number" name="id" placeholder="user id">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="email" placeholder="email">
    <input type="number" name="usergroupid" placeholder="user_group_id">
    <input type="submit" name="button" value="edit">
</form>

<form action="#" method="post">
    <h3>Delete User</h3>
    <input type="number" name="id" placeholder="user id">
    <input type="submit" name="button" value="delete">
</form>
<%@include file="/WEB-INF/views/footer.jsp"%>