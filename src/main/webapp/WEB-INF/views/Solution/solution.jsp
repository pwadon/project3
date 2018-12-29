<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<h1> Solution details</h1>
<p>${solution.getDescription()}</p>

<%@include file="/WEB-INF/views/footer.jsp"%>
