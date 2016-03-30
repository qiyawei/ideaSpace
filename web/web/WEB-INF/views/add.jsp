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

		<form action="/save.do" method="post">
		<legend>添加产品</legend>
		<label>产品名称</label>
		<input type="text" name="productname"/><br/>
		<label>价格</label>
		<input type="text" name="productprice" /><br/>
		<label>数量</label>
		<input type="text"  name="productnum"/><br/>
		<label>产地</label>
		<input type="text"  name="productaddress" /><br/>
		
		<div class="form-action">
		
			<Button class="btn btn-primary">添加</Button>
		
		</div>	
	</form>
</div>
</body>
</html>