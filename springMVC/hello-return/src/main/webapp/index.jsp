
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function (){
                // alert("button click")
                $.ajax({
                    url:"doStudentsAjax.do",
                    data:{
                        name:"姜春雨",
                        age:"34",
                    },
                    type:"post",
                    dataType:"json",
                    success:function (resq){
                        //resp返回的是json格式的字符串
                        // alert(resq.name+"  ;  "+resq.age)
                        $.each(resq,function (i,n){
                            alert(n.name+";"+n.age)
                        })
                    }
                })
            })

            $("#btn2").click(function (){
                // alert("button click")
                $.ajax({
                    url:"doStringData.do",
                    data:{
                        name:"姜春雨",
                        age:"34",
                    },
                    type:"post",
                    dataType:"text",
                    success:function (resq){
                        alert("返回的文本数据："+resq)
                    }
                })
            })
        })
    </script>
</head>
<body>
<form action="returnString.do" method="post">
    姓名：<input type="text" name="name">
    年龄: <input type="text" name="age">
    <input type="submit" name="提交参数">
</form>
<br>
<button id="btn" >发起ajax请求</button>
<button id="btn2">发送ajax请求返回的string是数据不是视图</button>
</body>
</html>
