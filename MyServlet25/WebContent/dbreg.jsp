<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db reg</title>
</head>
<body>
		
	<form action="UserCtrl" method="post">
		用户名：<input type="text" name="uname"> 
		密码：<input type="password" name="upwd"> 
		确认密码：<input type="password" name="upwd"> 
		<input type="submit" value="reg_Post">
		<input type="hidden" name="ichaction" value="reg" >
	
	</form>
</body>
</html>