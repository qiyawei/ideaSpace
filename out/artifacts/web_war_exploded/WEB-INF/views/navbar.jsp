<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		padding-top:60px;
	
	}
	


</style>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">

  <div class="navbar-inner">
  	<div class="container">
    <a class="brand" href="#">  产品在线商城</a>
    <ul class="nav">
      <li class="${param.menu == 'welcome' ? 'active' : ''}" ><a href="/welcome.do">首页</a></li>
      <li class="${param.menu == 'list' ? 'active' : ''}"><a href="/home.do">今日上新</a></li>
      <li class="${param.menu == 'last' ? 'active' : ''}"><a title="30分钟后将会下架"href="/last.do" >最后疯抢</a></li>
      <li><a href="#">即将上线</a></li>
    </ul>
    <ul class="nav pull-right">
      <li ><a href="/logout.do" >安全退出</a></li>
    </ul>
    </div>
  </div>
</div>

</body>
</html>