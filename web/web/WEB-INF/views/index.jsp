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

<div class="container">
	<c:choose>
		<c:when test="${param.state == 'error' }">
			<div class="alert alert-error">账号或密码错误</div>
		</c:when>
		<c:when test="${param.state == 'unlogin'}">
			<div class="alert  alert-error">请登录后再访问</div>
		</c:when>
		<c:when test="${param.state == 'logout'}">
			<div class="alert  alert-error">您已经安全退出</div>
		</c:when>
		<c:when test="${param.state == 'code'}">
			<div class="alert  alert-error">验证码错误</div>
		</c:when>
	</c:choose>



<%--
	<%
		String state = request.getParameter("state");
		if("error".equals(state)){
	%>
	<div class="alert alert-error">账号或密码错误</div>
	<%} else if("unlogin".equals(state)){%>

	<div class="alert">请登录后再访问</div>

	<%}else if("logout".equals(state)){ %>
		<div class="alert">您已经安全退出</div>
	<%}%>--%>
	<form id="loginform"action="/login.do" method="post">
		<legend>系统登录</legend>
		<label>账号</label>
		<input type="text" name="username"/><br/>
		<label>密码</label>
		<input type="password" name="password" id="name"/><br/>
		<c:if test="${param.num >= 3}">
			<label>请输入验证码</label>
			<input type="text" name="code"/>
			<img src="/image.png"/><a id="img">看不清换一张</a>
		</c:if>

		<input type="checkbox" name="rememberme" value="yes"/>记住我

		<div class="form-actions">

			<Button type="button" class="btn btn-primary">登陆</Button>

		</div>
	</form>
</div>
<script src="/static/js/jquery-1.10.1.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/md5.js"></script>
<script>

	$(function(){
		$("#img").click(function(){
			$("img").attr("src","/image.png?t="  + new Date().getTime())
		})
		$("#loginform").validate({
			errorElement:'span',
			errorClass:"text-error",

			rules:{
				username:{
					required:true
				},
				password:{
					required:true
				}
			},
			messages:{
				username:{
					required:"请输入账号"
				},
				password:{
					required:"请输入密码"
				}
			}
		});
		$(".btn").click(function(){
			//alert(456)
			var pwd = $("#name").val();
			pwd = CryptoJS.MD5(pwd);
			$("#name").val(pwd);
			$("#loginform").submit();
		})
	});

</script>
</body>
</html>