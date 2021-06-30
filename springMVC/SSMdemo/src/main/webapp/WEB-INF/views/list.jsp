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
<%--搭建显示页面--%>
<div class="container">
<%--    //标题--%>
    <div class="row">
        <div class="col-md-12" >
            <h1>SSM-CRUD</h1>
        </div>
    </div>
<%--    按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary btn-sm">新增</button>
            <button class="btn btn-danger btn-sm">删除</button>
        </div>
    </div>
<%--    显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                <tr>
                    <th>${emp.id}</th>
                    <th>${emp.empname}</th>
                    <th>${emp.gender}</th>
                    <th>${emp.email}</th>
                    <th>${emp.dept.deptname}</th>
                    <th>
                        <button class="btn btn-primary btn-sm">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
                        </button>
                        <button class="btn btn-danger btn-sm">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>删除
                        </button>
                    </th>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
<%--    分页条--%>
    <div class="row">
<%--        分页信息--%>
        <div class="col-md-6">
            当前处在第【${pageInfo.pageNum}】页，总共${pageInfo.total}条记录
        </div>
<%--            分页条--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${path}/emp.do?pn=1">首页</a> </li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${path}/emp.do?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
<%--                        高亮显示--%>
                        <c:if test="${pageNum==pageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum!=pageInfo.pageNum}">
                            <li><a href="${path}/emp.do?pn=${pageNum}">${pageNum}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${path}/emp.do?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="${path}/emp.do?pn=${pageInfo.pages}">尾页</a> </li>
                </ul>
            </nav>
    </div>
</div>
</body>
</html>
