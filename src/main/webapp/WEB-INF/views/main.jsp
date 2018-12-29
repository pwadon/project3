<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: paladyn
  Date: 27.12.18
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<c:forEach items="${solutions}" varStatus="solution" var="i">
    ${solution.get(i).getId()}
    ${solution.get(i).getCreated()}
    ${solution.get(i).getUpdated()}
    ${solution.get(i).getDescription()}
    ${solution.get(i).getExercise_id()}
    ${solution.get(i).getUsers_id()}
</c:forEach>

</body>
</html>
