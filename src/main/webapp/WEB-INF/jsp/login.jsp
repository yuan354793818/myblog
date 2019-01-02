<%--
  Created by IntelliJ IDEA.
  User: YJY
  Date: 2018/12/31
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <%@include file="../common/head.jsp"%>
    <%@include file="../common/tag.jsp"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">

    <title>登录</title>

    <!-- Custom styles for this template -->
    <link href="<%=base%>personal_css/floating-labels.css" rel="stylesheet">
</head>

<body>
<form class="form-signin" action="/user/login?redirect=${redirect}" method="post">
    <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">登录</h1>
    </div>

    <div class="form-label-group">
        <input type="text" name="userName"  id="inputEmail" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputEmail">用户名</label>
    </div>

    <div class="form-label-group">
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <label for="inputPassword">密码</label>
    </div>

    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> 记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
</form>
</body>
</html>

