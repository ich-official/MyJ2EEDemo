<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test title</title>
</head>
<body>
	hello world!你好
	
		
	<%!
		public String globalName="none";
		public void init(){
			globalName="ich_global";
		}
	%>
	<br></br>
	
	<%="表达式"+globalName  %>
	
	<br></br>
	<% 
		String name = "ich";
		out.println("局部变量"+name);
		init();
	%>
	<br></br>
	
	<%="表达式，和out.println等价"+globalName  %>
	<a href="dblogin.jsp">去登陆</a>
	<a href="dbreg.jsp">去注册</a>

</body>
</html>