<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<h2>Login Please!</h2>

<fieldset>
    <legend>Login</legend>
    ${message}
    <br>
    <form action="/account" method="post">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>User Name:</td>
                <td><input type = "text" name = "username"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type = "password" name = "password"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type = "submit" value="LOGIN"/></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
