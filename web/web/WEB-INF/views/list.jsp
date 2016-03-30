<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.kaishengit.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="navbar.jsp">
		<jsp:param value="list" name="menu"/>
</jsp:include>

<div class="container">
	<a href="/save.do" class="btn btn-success">添加产品</a>
	<a href="/exportcsv.do" class="btn btn-primary">导出Csv文件</a>
	<a href="/exportxls.do" class="btn btn-danger">导出Xls文件</a>
	<a href="/importxls.do" class="btn btn-danger">导入Xls文件</a>
	<a href="/exportsql.do" class="btn btn-warning">导出Sql文件</a>
		<table class="table">
		<thead>
			<tr>
				<th>产品名称</th>
				<th>价格</th>
				<th>数量</th>
				<th>产地</th>
				<th>#</th>
			</tr>
		</thead>
	
		<tbody>

			<c:forEach items="${page.list}" var="pr" varStatus="order">
				<tr>
					<td>${pr.productname} </td>
					<td>${pr.productprice}</td>
					<td>${pr.productnum}</td>
					<td>${pr.productaddress}</td>
					<td>
						<a data-id="${pr.id}" href="javascript:;" class="del">删除</a>
						<a  href="/edit.do?id=${pr.id}">修改</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
		<tr class="error">
			<td>总共${page.totalCount }条记录，${page.pageNo }/${page.pageTotals}页</td>
		</tr>
	</table>

	<div  style="float: right"class="pagination" id="pages"></div>

	<div style="float:left" class="pagination">
		<ul>
			<c:choose>
				<c:when test="${page.pageNo == 1}">
					<li class="disabled"><a href="javascript:;">首页</a></li>
					<li class="disabled"><a href="javascript:;">上一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/home.do?p=1">首页</a></li>
					<li><a href="/home.do?p=${page.pageNo-1}">上一页</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.pageNo == page.pageTotals}">
					<li class="disabled"><a href="javascript:;">下一页</a></li>
					<li class="disabled"><a href="javascript:;">末页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/home.do?p=${page.pageNo+1}">下一页</a></li>
					<li><a href="/home.do?p=${page.pageTotals}">末页</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>

</div>
<script src="/static/js/jquery-1.10.1.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>
	$(function(){
			$("#pages").twbsPagination({
				totalPages:${page.pageTotals},
				visiblePages:5,
				first:'首页',
				last:'末页',
				prev:'上一页',
				next:'下一页',
				href:"?p={{number}}"
			});

			$(".del").click(function(){

			var id = $(this).attr("data-id");
			if(confirm("确认要删除吗")){
				location.href="/del.do?id=" + id;
			}
		});
	})
	
</script>








</body>
</html>