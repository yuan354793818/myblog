<%--
  Created by IntelliJ IDEA.
  User: YJY
  Date: 2018/12/31
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- saved from url=(0037)https://v3.bootcss.com/examples/blog/ -->
<html lang="zh-CN">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="../common/head.jsp" %>
    <%@include file="../common/tag.jsp" %>
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>${blog.title}</title>
    <!-- Custom styles for this template -->
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
                    <a class="btn btn-sm" href="/login?redirect=${prePageUri}">登录</a>
                </c:when>
                <c:otherwise>
                    <span style="color: tomato;">${loginUser.userName}</span>
                    <a class="btn btn-sm" href="/user/logout?redirect=${prePageUri}">登出</a>
                    <a class="btn btn-sm" href="/blog/add">写博客</a>
                    <a class="btn btn-sm" href="/blog/${blog.blogId}/edition">编辑该博客</a>
                </c:otherwise>
            </c:choose>
        </nav>
    </div>
</div>

<div class="container">

    <div class="col-sm-9 blog-header">
        <span style="font-size: 33px;font-weight: bold">${blog.title}</span>
        <p class="lead blog-description">这个人很懒什么也没有留下</p>
    </div>

    <div class="row">

        <div class="col-sm-9 blog-main">

            <div class="blog-post">
                ${blog.bContent}
            </div><!-- /.blog-post -->


            <nav>
                <ul class="pager">
                    <c:if test="${preBlog!=null}">
                        <li><a href="/blog/${preBlog}/show">上一篇</a></li>
                    </c:if>
                    <c:if test="${nextBlog!=null}">
                        <li><a href="/blog/${nextBlog}/show">下一篇</a></li>
                    </c:if>
                </ul>
            </nav>

        </div><!-- /.blog-main -->

        <div class="col-sm-3 blog-sidebar">
            <c:forEach var="c" items="${comment}">
                <div class="sidebar-module sidebar-module-inset">
                    <h5>
                        <c:choose>
                            <c:when test="${c.user==null}">
                                游客
                            </c:when>
                            <c:otherwise>
                                ${c.user.userName}
                            </c:otherwise>
                        </c:choose>
                    </h5>
                    <p>${c.cContent}<br>
                        <fmt:formatDate value="${c.createTime}" pattern="yyyy/MM/dd HH/mm/ss"></fmt:formatDate>
                    </p>
                    <c:if test="${loginUser!=null}">
                        <button type="button"  class="btn btn-sm btn-primary" onclick="comment_controller.delete(${c.commentId})">删除</button>
                    </c:if>
                </div>
            </c:forEach>
                你想说些什么：
                <textarea id="speech" class="text-area text-input"></textarea><br>
                <button type="button" class="btn btn-sm btn-primary" onclick="comment_controller.add(${blog.blogId})">提交</button>
        </div><!-- /.blog-sidebar -->

    </div><!-- /.row -->

</div><!-- /.container -->

<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.
    </p>
    <p>
        <a href="https://v3.bootcss.com/examples/blog/#">Back to top</a>
    </p>
</footer>
<script type="text/javascript" src="<%=base%>resources/script/common.js"></script>
</body>
</html>
