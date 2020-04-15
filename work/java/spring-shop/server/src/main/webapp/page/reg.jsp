<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/user/reg" method="post">
        <label>
            用户名：
            <input type="text" name="username" placeholder="用户名">
        </label><br/>
        <label>
            密  码:
            <input type="password" name="password" placeholder="密码">
        </label><br/>
        <label>
            年  龄:
            <input type="text" name="age" placeholder="年龄">
        </label><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
