<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2019/10/9
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-color:seashell;
        }
    </style>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('button').click(function(){
                var title = $('input[name=title]').val();
                var author = $('input[name=author]').val();
                var content = $('#text').val();
                var publishDate = $('input[name=publishDate]').val();
                var blog = { };
                blog.title = title;
                blog.content = content;
                blog.publishDate = publishDate;
                blog.author = author;
                alert("成功了哟！！！");
              $.post("/blog/insert",blog,function (msg) {
              },"json");
                $(location).attr('href', '../blog/zhan?title='+blog.title+'');
            })
        })
    </script>
</head>
<body>
<h3>请输入：</h3>
<label style="display: inline-block;margin-bottom: 20px">文章标题：</label><input type = "text" name = "title" /><br/>
<label style="display: inline-block;margin-bottom: 20px">文章作者：</label><input type = "text" name = "author" /><br/>
<div><label style="display: inline-block;margin-bottom: 20px">文章内容：</label></div>
<textarea id="text" style="margin-left:80px;width: 900px;height: 300px"></textarea><br/>
<label style="margin-top:20px;display: inline-block;margin-bottom: 20px">发表时间:</label>
<input type = "date" name = "publishDate" /><br/>
<button style="display: inline-block;margin-left: 500px;">提交</button>

<h3>点击展示博客页面：</h3>
<a href = "/blog/index" style="margin-left: 150px;text-decoration:none;color: darkblue">返回</a>
</body>
</html>
