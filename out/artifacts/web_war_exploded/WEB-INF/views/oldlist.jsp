<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.kaishengit.entity.OldProduct"%>
<%@page import="java.util.List"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp">
	<jsp:param value="last" name="menu"/>
</jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
</head>
<body>

<%

List<OldProduct> list =(List<OldProduct>)request.getAttribute("productList");

%>
<div class="container">
	<a href="add.jsp" class="btn btn-danger">清除产品</a>
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
			<%
				for(OldProduct pr : list){
			
			%>
		
			<tr>
				<td><%=pr.getProductname() %></td>
				<td><%=pr.getProductprice() %></td>
				<td><%=pr.getProductnum() %></td>
				<td><%=pr.getProductaddress() %></td>
				<td>
					<a data-id="<%=pr.getId() %>" href="javascript:;" class="del">下架</a>
				</td>
			</tr>
			<%} %>
		
		</tbody>
	</table>
</div>
<script src="/static/js/jquery-1.10.1.min.js"></script>
<script>
	$(function(){
		$(".del").click(function(){
			
			var id = $(this).attr("data-id");
			if(confirm("确认要删除吗")){
				location.href="/lastdel.do?id=" + id;
			}
		});
	});
	
</script>








</body>
</html>
</body>
</html>