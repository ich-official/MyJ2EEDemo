<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reg</title>
</head>
<body>
	get方式：<br/>
	<form action="showreg.jsp" method="get">
	<input type="text" name="uname"/> 
	<input type="password" name="upwd"/> 
	<input type="checkbox" name="uhobbies" value="111"/> 111
	<input type="checkbox" name="uhobbies" value="222"/> 222
	<input type="checkbox" name="uhobbies" value="333"/> 333
	<input type="submit" value="reg_Get">
	
	</form>
	
	post方式：<br/>
	<form action="showreg.jsp" method="get">
	<input type="text" name="uname"/> 
	<input type="password" name="upwd"/> 
	<input type="checkbox" name="uhobbies" value="111"/> 111
	<input type="checkbox" name="uhobbies" value="222"/> 222
	<input type="checkbox" name="uhobbies" value="333"/> 333
	<input type="submit" value="reg_Post">
	
	</form>
	
</body>
</html>