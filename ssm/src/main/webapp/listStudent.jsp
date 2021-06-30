<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 22498
  Date: 2021/5/15
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
            +request.getContextPath()+"/";
%>
<html>
<head>
    <title>学生AJAX</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function (){
            loadStudent();
            $("#btn").click(function (){
             loadStudent();
            })
        })
        function loadStudent(){
            $.ajax({
                url:"student/listStudent.do",
                type:"get",
                dataType:"json",
                success:function (resp){

                    $("#info").html("");
                    $.each(resp,function (i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>").append("<td>"+n.name+"</td>").append("<td>"+n.age+"</td>").append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
<div align="center">
    <table>
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        </thead>
        <tbody id="info">
        </tbody>
    </table>
    <input type="button" id="btn" value="查询">
</div>
</body>
</html>
