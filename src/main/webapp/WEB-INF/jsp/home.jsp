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
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">
    <title>博客首页</title>
    <link href="<%=base%>personal_css/blog.css" rel="stylesheet">
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
<div class="headdown">
    <h3 style="text-align: center;color:slateblue">Welcome yjy's blog</h3>
</div>
<div class="container">
    <div class="row">

        <div class="col-sm-9 blog-main">
            <div class="blog-post">
                <table>
                    <c:forEach items="${titlelist}" var="blog" varStatus="s">
                        <tr>

                            <td>
                                <a href="/blog/${blog.blogId}/show">
                                    <span style="font-size:30px;color:<c:if test="${s.index % 2 ==0}">palevioletred</c:if>">${blog.title}</span>
                                </a>
                            </td>

                            <td>
                                <c:if test="${blog.user!=null}">By</c:if>&nbsp;&nbsp;${blog.user.userName}&nbsp;
                                <c:if test="${loginUser!=null}">
                                    <a href="/blog/${blog.blogId}/edition">编辑</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div><!-- /.blog-post -->
        </div><!-- /.blog-main -->

        <div class="col-sm-3 ">
            <div class="sidebar-module sidebar-module-inset">
                <h4>袁嘉宇<br>出生1995年4月13日，四川成都人<br>爱好编程，看书，画画</h4>
            </div>
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

</body>
</html>
