
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="wode.do" method="post">
    姓名：<input type="text" name="name">
    年龄: <input type="text" name="age">
    <input type="submit" name="提交参数">
</form>
<span>请求参数和处理器的参数不一样</span>
<form action="getparam.do" method="post">
    姓名：<input type="text" name="rname">
    年龄: <input type="text" name="rage">
    <input type="submit" name="提交参数">
</form>


<span>使用对象来接受请求参数</span>
<form action="getObject.do" method="post">
    姓名：<input type="text" name="name">
    年龄: <input type="text" name="age">
    <input type="submit" name="提交参数">
</form>
</body>
</html>
