
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
                    +request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>



<p>实现请求转发的操作</p>
<form action="user/wode.do" method="post">
    姓名：<input type="text" name="name">
    年龄: <input type="text" name="age">
    <input type="submit" name="提交参数">
</form>



<br>
<p>实现重定向操作</p>
<form action="user/redirect.do" method="post">
    姓名：<input type="text" name="name">
    年龄: <input type="text" name="age">
    <input type="submit" name="提交参数">
</form>
</body>
</html>
