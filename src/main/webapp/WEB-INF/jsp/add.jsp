<%--
  Created by IntelliJ IDEA.
  User: YJY
  Date: 2018/12/30
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="../common/head.jsp" %>
    <%@include file="../common/tag.jsp" %>
    <script type="text/javascript" src="<%=base%>utf8-jsp/jquery-3.3.1.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=base%>utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=base%>utf8-jsp/ueditor.all.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="<%=base%>utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=base%>resources/script/common.js"></script>
    <link href="<%=base%>personal_css/blog.css" rel="stylesheet">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="/blog/homepage">主页</a>
            <c:choose>
                <c:when test="${loginUser==null}">
                    <a class="btn btn-sm" href="/login">登录</a>
                </c:when>
                <c:otherwise>
                    <span style="color: tomato;">${loginUser.userName}</span>
                    <a class="btn btn-sm" href="/user/logout">登出</a>
                    <a class="btn btn-sm" href="/blog/add">写博客</a>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</div>
<h2>标题：<input id="blog_title" type="text" placeholder="请写入标题" style="width: 1100px"/>&nbsp;<a href="javascript:history.go(-1)" class="btn btn-sm btn-primary">返回</a></h2>
<div>
    <textarea id="editor"  style="width:1200px;height:800px;"></textarea>
</div>
<div id="btns">
    <button onclick="blog_editor.add_commit()">提交</button>
</div>
<script type="text/javascript">
    $(function () {
        var editor = UE.getEditor('editor');
    });
</script>
</body>
</html>
