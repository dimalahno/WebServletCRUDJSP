<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
<h1>Edit User</h1>
<hr>
    <form action="edit" method="post">
        <table>
            <tr><td></td><td><input type='hidden' name='id' value="${uId}"/></td></tr>
            <tr><td>Name:</td><td><input type='text' name='name' value="<c:out value="${uName}"/>"/></td></tr>
            <tr><td>Age:</td><td><input type='number' name='age' value="<c:out value="${uAge}"/>"/></td></tr>
            <tr><td>Email:</td><td><input type='email' name='email' value="<c:out value="${uEmail}"/>"/></td></tr>
            <tr><td>Role:</td><td><input type='text' name='role' value="<c:out value="${uRole}"/>"/></td></tr>
            <tr><td colspan='2'><input type='submit' value='Edit&Save'/></td></tr>
        </table>
    </form>
</body>
</html>
