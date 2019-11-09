<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2019/10/10
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor2/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor2/ueditor/ueditor.all.min.js"></script>
    <link href="${pageContext.request.contextPath}/ueditor2/ueditor/themes/default/css/ueditor.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor2/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div id="editor" style="height:360px;border: 1px solid black">
    <script type="text/javascript" charset="utf-8">
        UE.getEditor('editor');
    </script>
</div>

</body>
</html>
