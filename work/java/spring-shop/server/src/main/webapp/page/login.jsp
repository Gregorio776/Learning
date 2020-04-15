<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/login" method="post">
        <label for="username">用户名：</label>
        <input id="username" type="text" name="username" placeholder="用户名"><br>
        <label for="password">密  码：</label>
        <input id="password" type="password" name="password" placeholder="密码"/><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
