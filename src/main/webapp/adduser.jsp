<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
</head>
<body>
    <h1>Add User</h1>
    <hr>
    <form action="add" method="post">
        <table>
            <tr><td>Name:</td><td><input type='text' name='name'/></td></tr>
            <tr><td>Age:</td><td><input type='number' name='age'/></td></tr>
            <tr><td>Email:</td><td><input type='email' name='email'/></td></tr>
            <tr><td>Role:</td><td><input type='text' name='role'/></td></tr>
            <tr><td colspan='2'><input type='submit' value='Save '/></td></tr>
        </table>
    </form>
</body>
</html>
