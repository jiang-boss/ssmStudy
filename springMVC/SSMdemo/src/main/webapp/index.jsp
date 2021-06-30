<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("path",request.getContextPath());
    %>
    <link rel="stylesheet" href="${path}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="${path}/static/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="${path}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%--员工添加模态框--%>
<div class="modal fade" id="addemp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="formdeta">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-10">
                            <input type="empname" name="empname" class="form-control" id="inputempname" placeholder="xxxxx">
                            <span id="helpname" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工邮箱</label>
                        <div class="col-sm-10">
                            <input type="empname" name="email" class="form-control" id="inputEmail" placeholder="xxxx@qq.ocm...">
                            <span id="helpemail" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工性别</label>
                        <div class="col-sm-10">
                            <%--  单选按钮选择男女--%>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="Radio1_gender" value="m" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="Radio2_gender" value="f"> 女
                            </label>
                        </div>
                    </div>
<%--                    员工部门--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工部门</label>
                        <div class="col-sm-3">
                            <select id="dept_select" class="form-control" name="dId" >
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save_emp">保存</button>
            </div>
        </div>
    </div>
</div>
<%--员工修改的模态框--%>
<div class="modal fade" id="updateEmp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="updateform">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-10">
<%--                            <input type="empname" name="empname" class="form-control" id="updateempname" placeholder="xxxxx">--%>
                            <p class="form-control-static" id="empName_update">EmployeeName</p>
                            <span id="helpname_update" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工邮箱</label>
                        <div class="col-sm-10">
                            <input type="empname" name="email" class="form-control" id="updateEmail" placeholder="xxxx@qq.ocm...">
                            <span id="updatehelpemail" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工性别</label>
                        <div class="col-sm-10">
                            <%--  单选按钮选择男女--%>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="Radio1_gender_update" value="m" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="Radio2_gender_update" value="f"> 女
                            </label>
                        </div>
                    </div>
                    <%--                    员工部门--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工部门</label>
                        <div class="col-sm-3">
                            <select id="dept_select_update" class="form-control" name="dId" >
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="update_emp_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<%--搭建显示页面--%>
<div class="container">
    <%--    //标题--%>
    <div class="row">
        <div class="col-md-12" >
            <h1>SSM-CRUD整合</h1>
        </div>
    </div>
    <%--    按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-10">
            <button class="btn btn-primary btn-sm" id="addempModel" >新增</button>
            <button class="btn btn-danger btn-sm" id="delete_all">删除</button>
        </div>
    </div>

    <%--    显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover table-bordered " id="table_emp">
                <thead>
                <tr>
                    <th>
                        全选<input type="checkbox" id="check_all"/>
                    </th>
                    <th>id</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <%--    分页条--%>
    <div class="row">
        <%--        分页信息--%>
        <div  class="col-md-6" id="pageinfo">
        </div>
        <%--            分页条--%>
        <div class="col-md-6" id="pagenav">

        </div>
    </div>
        <script type="text/javascript">
            var pageNumTotal,currentPage;//最后一页和当前页的变量
            $(function (){
                //去首页
            ajaxpage(1)
            })
            //处理跳转的页面的ajax请求
            function ajaxpage(n){
                $.ajax({
                    url:"${path}/jsonemps",
                    data:"pn="+n,
                    type:"GET",
                    success:function (result){
                        //处理回调函数
                        console.log(result);//解析显示数据
                        table_emp(result);
                        pageinfo(result);
                        PageNav(result);
                    }
                })
            }
            function table_emp(result){
                //每次加载都清空
                $("#table_emp tbody").empty();
                //处理表格
                var emps=result.extend.pageinfo.list;
                $.each(emps,function (index,emp){
                    //遍历所有的数据
                    // alert(emp.empname);
                    var checks=$("<td><input type='checkbox' class='checkbox_item'></td>")
                    var empid=$("<td></td>").append(emp.id);
                    var empname=$("<td></td>").append(emp.empname);
                    var gender=$("<td></td>").append(emp.gender=="m"?"男":"女");
                    var email=$("<td></td>").append(emp.email);
                    var deptname=$("<td></td>").append(emp.dept.deptname);
                    var editbtn=$("<button></button>").addClass("btn btn-primary btn-sm update_emp").append(
                        $("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑")
                    )
                    //为编辑按钮创建一个id属性
                    editbtn.attr("editempid",emp.id)
                    var delbtn=$("<button></button>").addClass("btn btn-danger btn-sm delete_emp").append(
                        $("<span></span>").addClass("glyphicon glyphicon-pencil").append("删除")
                    )
                    //未删除按钮绑定一个属性供删除的时候使用
                    delbtn.attr("delempid",emp.id)

                    var btntd=$("<td></td>").append(editbtn).append(" ").append(delbtn);
                    $("<tr></tr>").append(checks).append(empid).append(empname).append(gender).append(email)
                        .append(deptname).append(btntd).appendTo("#table_emp tbody")
                })
            }
            /**
             * @param result
             */
            function pageinfo(result){
                $("#pageinfo").empty()
                //解析显示分页信息
                $("#pageinfo").append("当前处在第【"+result.extend.pageinfo.pageNum+"】页，总共条"+result.extend.pageinfo.total+"记录")
                pageNumTotal=result.extend.pageinfo.total
                currentPage=result.extend.pageinfo.pageNum
            }
            function PageNav(result){
                //解析显示分页条pagenav
                $("#pagenav").empty();
                var ul=$("<ul></ul>").addClass("pagination")
                var firstPage=$("<li></li>").append($("<a></a>").append("首页").attr("href","#"))
                var prepage=$("<li></li>").append($("<a></a>").append("&laquo;"))
                if (result.extend.pageinfo.hasPreviousPage == false){
                    firstPage.addClass("disabled");
                    prepage.addClass("disabled");
                }else {
                    firstPage.click(function (){
                        ajaxpage(1)
                    })
                    prepage.click(function (){
                        ajaxpage(result.extend.pageinfo.pageNum-1)
                    })
                }
                var nextpage=$("<li></li>").append($("<a></a>").append("&raquo;"))
                var lastPage=$("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
                if (result.extend.pageinfo.hasNextPage === false){
                    nextpage.addClass("disabled");
                    lastPage.addClass("disabled");
                }else {
                    nextpage.click(function (){
                        ajaxpage(result.extend.pageinfo.pageNum+1)
                    })
                    lastPage.click(function (){
                        ajaxpage(result.extend.pageinfo.total)
                    })
                }
                ul.append(firstPage).append(prepage);
                $.each(result.extend.pageinfo.navigatepageNums,function (index,n){
                    var numli=$("<li></li>").append($("<a></a>").append(n))
                    if (result.extend.pageinfo.pageNum==n){
                        numli.addClass("active")
                    }
                numli.click(function (){
                    ajaxpage(n);
                })
                    ul.append(numli)
                })
                ul.append(nextpage).append(lastPage);
                var nav=$("<nav></nav>").attr("aria-label","Page navigation").append(ul)
                nav.appendTo("#pagenav")
            }
            //完整的清除表单的数据和校验信息
            function resetMethod(ele){
                //清除校验信息
                $(ele)[0].reset();
                //清空表单样式
                $(ele).find("*").removeClass("has-error has-success")
                $(ele).find(".help-block").text("")
            }
            //弹出模态框
            $("#addempModel").click(function (){
                //弹出之前  发送ajax请求获取到所有的部门信息 并且清除表单数据
                //防止之前请求过来的数据跳过验证 表单重置
                // $("#formdeta")[0].reset();
                resetMethod("#formdeta");
                //弹出之前显示员工的部门信息
                getDept("#dept_select");
                $("#addemp").modal({
                    backdrop:"static",
                })
            })
            function getDept(ele){
                $(ele).empty();
                $.ajax({
                    url:"${path}/dept",
                    type: "GET",
                    success:function (resq){
                        // console.log(resq)
                        $.each(resq.extend.depts,function (){
                            var select_dept=$("<option></option>").append(this.deptname).attr("value",this.id)
                            select_dept.appendTo(ele)
                        })
                    }
                })
            }
            //这里处理校验的方法
            function validate(){
                //对需要提交的数据进行校验 名字和邮箱
                var empName=$("#inputempname").val()
                var regName=/(^[a-zA-Z0-9_-]{4,16}$)|(^[\u4E00-\u9FA5]{2,5})/;
                if(!regName.test(empName)){
                    // alert("用户名的格式不正确")
                    showinfo("#inputempname","error","你输入的名称格式不正确！")
                    return false
                }else {
                    showinfo("#inputempname","success","")

                }
                var email=$("#inputEmail").val()
                var regEmail=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if(!regEmail.test(email)){
                    // alert("邮箱的格式不正确！")
                    showinfo("#inputEmail","error","你输入的邮箱格式不正确！")
                    return  false;
                }else {
                    showinfo("#inputEmail","success","")
                }
                return  true;
            }
            //抽取共同错区提示信息（前端的校验）
            function showinfo(ele,status,msg){
                $(ele).parent().removeClass("has-success has-error")
                $(ele).next("span").text("")
                if("success"==status){
                    //成功
                    $(ele).parent().addClass("has-success")
                }else if("error"==status){
                 //失败
                    $(ele).parent().addClass("has-error")
                    $(ele).next("span").text(msg)
                }
            }
            //处理ajax增加员工的操作
            $("#save_emp").click(function (){
                //首先校验表单数据、判断邮箱和名称的格式正确不（）
                // if(!validate()){
                //     return false;
                // }
                //在这里判断ajax请求是否可用不可用不让提交（change中赋值）
                //有个问题：当发送ajax验证到用户名不可用的情况下  在来点击提交按钮  校验的信息会显示正确 但是提交不了
                // 因为前端的校验是正确的 ajax请求失败给按钮添加了一个属性 ajax_exit值为false (现在添加一个后端校验jsr303)
                if($(this).attr("ajax_exit")=="false"){
                    return false
                }
                //处理增加员工的ajax
                $.ajax({
                    <%--url:"${path}/dept",--%>
                    url:"${path}/empSave",
                    data:$("#formdeta").serialize(),
                    type:"POST",
                    success:function (resq){
                        //这里要判断是否校验成功  code状态码来判断
                        if (resq.code==100){
                            //处理成功后关闭模态框
                            $("#addemp").modal("hide")
                            //并且转到最后一页
                            ajaxpage(pageNumTotal+1);
                        }else {
                            //这里说明状态码是200 用户校验错误添加失败 显示错误信息
                            console.log(resq)
                            // alert(resq.extend.errormsg.email)
                            if (undefined!=resq.extend.errormsg.email){
                                showinfo("#inputEmail","error",resq.extend.errormsg.email)
                            }
                            if (undefined!=resq.extend.errormsg.empname){
                                showinfo("#inputempname","error",resq.extend.errormsg.empname)
                            }
                        }

                    }
                })
            })
            //给添加员工的输入框绑定单元事件 发送ajax请求
            $("#inputempname").change(function (){
                var empName =this.value;
                $.ajax({
                    url:"${path}/exitName",
                    data:"empName="+empName,
                    type:"POST",
                    success:function (resp){
                        // alert(resp.code)
                        if (resp.code==100){
                            //此时是成功的情况
                            showinfo("#inputempname","success","用户名可用！")
                            $("#save_emp").attr("ajax_exit","success")
                        }else {
                            //这里是失败的情况
                            showinfo("#inputempname","error",resp.extend.ajax_err)
                            $("#save_emp").attr("ajax_exit","false")
                        }
                    }
                })
            })
        /*处理修改员工的员工的信息这里给所有的编辑按钮绑定单击事件 这里不能使用$("#update_emp").click()绑定事件
        * 绑定事件
        * */
            $(document).on("click",".update_emp",function (){
                // alert("dsds");
                //这里还要查询员工的部门信息
                getDept("#dept_select_update")
                getemp($(this).attr("editempid"));
                //把员工的ID信息传递给模态框的更改按钮
                $("#update_emp_btn").attr("empid",$(this).attr("editempid"))
                $("#updateEmp").modal({
                    backdrop:"static",
                })
            })
            function getemp(id){
                $.ajax({
                    url:"${path}/emp/"+id,
                    type:"GET",
                    success:function (result){
                        // alert(result.extend.emp.empname)
                        //回显要修改的员工信息
                        $("#empName_update").text(result.extend.emp.empname)
                        $("#updateEmail").val(result.extend.emp.email)
                        $("#updateEmp input[name=gender]").val([result.extend.emp.gender])
                        $("#updateEmp select").val([result.extend.emp.dId])
                    }
                })
            }
            //给更新员工的按钮绑定单元事件
            $("#update_emp_btn").click(function (){
                var empid=$(this).attr("empid")
                //处理判断邮箱是否合法
                var email=$("#updateEmail").val()
                var regEmail=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if(!regEmail.test(email)){
                    // alert("邮箱的格式不正确！")
                    showinfo("#updateEmail","error","你输入的邮箱格式不正确！")
                    return  false;
                }else {
                    showinfo("#updateEmail","success","")
                }
                //邮箱验证成功后 发送ajax请求修改员工的信息
                $.ajax({
                    url:"${path}/emp/"+empid,
                    type:"PUT",
                    data:$("#updateform").serialize(),
                    success:function (resp){
                        //修改完关闭模态框
                        $("#updateEmp").modal("hide")
                        //回到本页面
                        ajaxpage(currentPage)
                    }
                })
            })
            //删除的操作
            $(document).on("click",".delete_emp",function (){
                var id=$(this).attr("delempid")
                // alert(id)
                 deleteEmp(id)
            })
            function deleteEmp(id){
                $.ajax({
                    url:"${path}/delEmp/"+id,
                    type:"DELETE",
                    success:function (resq){
                        //处理成功返回本页
                        ajaxpage(currentPage)
                    }
                })
            }

            //处理全选全不选的操作
            $("#check_all").click(function (){
                //判断当前的选择按钮是否被选中 这里一般不用attr attr用于自定义的属性  这里使用 prop
                // alert($(this).prop("checked")) 将下面的所有选择框的状态和全选的按钮状态相同
                $(".checkbox_item").prop("checked",$(this).prop("checked"))

            })
            $(document).on("click",".checkbox_item",function (){
                // alert($(".checkbox_item:checked").length)弹出当前勾选了多少个选择框
                //这里判断是否全选了
                var flag=$(".checkbox_item:checked").length==$(".checkbox_item").length
                $("#check_all").prop("checked",flag)
            })
            //这里执行批量删除的操作
            $("#delete_all").click(function (){
                var empsName=""
                var empsid=""
                $.each($(".checkbox_item:checked"),function (){
                    // alert($(this).parents("tr").find("td:eq(1)").text());
                    empsName+=$(this).parents("tr").find("td:eq(2)").text()+","
                    empsid+=$(this).parents("tr").find("td:eq(1)").text()+"-"
                })
                empsNames=empsName.substring(0,empsName.length-1)
                del_ids=empsid.substring(0,empsid.length-1);
                if(confirm("确认删除【"+ empsNames+"】吗？")){
                    //这里发送ajax请求批量删除
                    $.ajax({
                        url:"${path}/delEmp/"+del_ids,
                        type:"DELETE",
                        success:function (resq){
                            alert(resq.msg)
                            //回到当前页面
                            ajaxpage(currentPage);
                        }
                    })
                }
                $("#check_all").prop("checked",false)
            })
        </script>
</body>
</html>
