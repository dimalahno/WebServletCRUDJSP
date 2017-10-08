
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h2>User List</h2>
<hr>
<table border="1", width="100%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Email</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.age}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.role}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
