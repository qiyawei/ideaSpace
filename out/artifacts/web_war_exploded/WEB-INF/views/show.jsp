<%@page import="com.kaishengit.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
</head>
<body>

<div class="container">	
	<form action="/update.do" method="post">
		<legend>修改产品</legend>
		<input type="hidden" name="id" value="${prod.id}"/>
		<label>产品名称</label>
		<input type="text" name="prodname" value="${prod.productname}"/>
		<label>价格</label>
		<input type="text" name="prodprice" value="${prod.productprice}"/>
		<label>数量</label>
		<input type="text" name="prodnum" value="${prod.productnum}"/>
		<label>产地</label>
		<input type="text" name="prodaddress" value="${prod.productaddress}"/>
		
		<div class="form-action">
		
			<button class="btn btn-primary">保存</button>
		
		</div>
	
	</form>
	
</div>	
	
	
	
	
</body>
</html>