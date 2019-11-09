<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
</head>
<body>
   <div>博客列表</div>
     <div>
         <ul class="list">
         </ul>
     </div>
   <script>
       $(document).ready(function () {
           get();
       })
       function get() {
           var ul = $('ul.list');
           ul.empty();
           $.post('${pageContext.request.contextPath}/blog/all',{},
               function (data) {
                    alert(data);
                    for(var i = 0;i<data.length;i++){
                        var blog = data[i];
                        $('<li>\n' +
                            '     <a href="/blog/zhan?title='+blog.title+'" class="blog-title">'+blog.title+'</a>\n' +
                            '    <span class="blog-publishTime">'+blog.publishDate+'</span>\n' +
                            '   <span class="blog-author">'+blog.author+'</span>\n' +
                            '</li>\n').appendTo(ul);
                    }
               },'json')
       }
   </script>

</body>
</html>