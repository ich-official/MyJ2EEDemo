<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB login</title>
</head>
<body>

	
	<form action="UserController" method="post">
		用户名：<input type="text" name="uname"> 
		密码：<input type="password" name="upwd"> 
		<input type="submit" name="checkName" value="login_Post">
		<input type="hidden" name="ichaction" value="login" >
	</form>



</body>
</html>