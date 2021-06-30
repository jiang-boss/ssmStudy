
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
<%--加入el表达式--%>
<form action="user/wode.do" method="post">
    姓名：<input type="text" name="name">
    年龄: <input type="text" name="age">
    <input type="submit" name="提交参数">
</form>
</body>
</html>
