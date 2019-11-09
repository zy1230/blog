<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2019/10/9
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <style>
        body{
            background-color:seashell;
        }
    </style>
</head>
<body>

<%
    String title = request.getParameter("title");
    session.setAttribute("title",title);
    if(title!=null){
%>
<a id="title" style="color: brown">${title}</a>
<%
    }
%>

<div style="padding-top:10px;width:1100px;margin:0 auto;">
    <div class="blog-title" style="text-align:center;height:30px;width:300px;margin:0 auto"></div>
    <div class="blog-content" style="margin:0 auto;padding-top:10px;padding-left:30px;width:850px;height:400px;border: 1px solid black"></div>
    <div class="blog-author" style="margin-top:10px;margin-left: 900px;"></div>
    <div class="blog-publishDate" style="margin-top:10px;margin-left: 755px;"></div>
</div>
<br/>
<br/>
<div style="width:200px;margin: 0 auto;">
    <a href="/blog/index" style="text-decoration: none;display: inline-block;margin-left: 50px;">返回博客列表</a>
</div>
<script>

    function get(){
        var title = $('#title').html();
        alert(title)
        $.post('${pageContext.request.contextPath}/blog/title',
            {title:title},
            function (data) {
                var blog = data;
                $('div.blog-title').html(blog.title);
                $('div.blog-content').html(blog.content);
                $('div.blog-author').html("作者："+blog.author);
                $('div.blog-publishDate').html("发表时间:"+blog.publishDate);
            },'json');
    }
    $(document).ready(function () {
        get();
    });
</script>
</body>
</html>
