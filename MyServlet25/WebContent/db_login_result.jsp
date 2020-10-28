<%@page import="com.ich.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login result</title>
</head>
<body>
		<%
			User u=(User)session.getAttribute("userInfo");
			if(u!=null){
				if(u.isLogin()){
					out.print("登陆成功");

				}
			}
		%>
		<form action="ArticleCtrl" method="post">
			<input type="submit" name="gomain" value="去操作页面">
			<input type="hidden" name="ichaction" value="queryall" >
		
		</form>
		
</body>
</html>