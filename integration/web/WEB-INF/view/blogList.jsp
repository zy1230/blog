<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2019/10/8
  Time: 11:01
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
    var pageNum=1,pageSize=5,author='',publishDate='';
    //,blog:blog
    function getData() {
        $.post("${pageContext.request.contextPath}/blog/page",
            {pageNum:pageNum,pageSize:pageSize,author:author,publishDate:publishDate},
            function(data){
          //  alert("kkk");
           // console.log(data);
                var ul = $("ul.list");
                ul.empty();
                for(var i = 0;i < data.list.length;i++){
                  var blog = data.list[i];
                    $('<li>\n' +
                        '     <a href="/blog/zhan?title='+blog.title+'" class="blog-title">'+blog.title+'</a>\n' +
                        '    <span class="blog-publishTime">'+blog.publishDate+'</span>\n' +
                        '   <span class="blog-author">'+blog.author+'</span>\n' +
                        '</li>\n').appendTo(ul);
                }
if(data.isFirstPage){
                    $('a.prev-page').hide();
}else{
    $('a.prev-page').show();
}
if(data.isLastPage){
    $('a.next-page').hide();
}else{
    $('a.next-page').show();
}
$('span.current-page').html("第"+data.pageNum+"页");
        },'json');
    }


    $(document).ready(function(){
        getData();
        $('.search-box button').click(function () {
            author = $('input[name=author]').val();
            publishDate = $('input[name=publishDate]').val();
            getData();
        });
        $('a.prev-page').click(function () {
            pageNum--;
            getData();
        });
        $('a.next-page').click(function () {
            pageNum++;
            getData();
        });
    });
</script>
    <style>
        .blog-title{
            text-decoration: none;
            display: inline-block;
            width: 100px;
            height: 50px;
        }
        .blog-publishTime{
            text-decoration: none;
            display: inline-block;
            width: 200px;
            height: 50px;
        }
        .blog-author{
            text-decoration: none;
            display: inline-block;
            width: 100px;
            height: 50px;
        }
    </style>

</head>
<body>
<h3>条件查询：</h3>
<div class="search-wrapper">
<div class="search-box" style="float:left;overflow: hidden;">
    <label>
        按作者：
    </label>
    <input type="text" name="author"/>
</div>
<div class="search-box" style="float:left;overflow: hidden;margin-left: 20px;margin-right: 20px">
    <label>
        按时间：
    </label>
    <input type="text" name="publishDate"/>
</div>
<div class="search-box" style="margin-left: 20px">
<button>查询</button>
</div>
</div>
<h3>博客列表展示：</h3>
<div style="margin-left: 140px">
    <a style="display:inline-block;margin-right: 100px">标题</a>
    <a style="display:inline-block;margin-right: 105px">发布时间</a>
    <a>作者</a>

</div>
<div class="list-wrapper" style="margin-left: 100px;">
    <ul class="list">
    </ul>
</div>
<div class="page-wrapper" style="margin-left: 120px;">
    <a href="#" class="prev-page" style="text-decoration:none;">&lt;</a>
    <span class="current-page"></span>
    <a href="#" class="next-page" style="text-decoration:none;">&gt;</a>
</div>
<br/>
<h3>点击添加文章：</h3>
<div style="width:200px;height:200px;margin-left: 130px;margin-top: 10px">
    <a href="/blog/add" style="text-decoration:none;">添加</a>
</div>
</body>
</html>
