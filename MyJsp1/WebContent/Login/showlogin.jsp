<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show login</title>
</head>
<body>
		<%
			request.setCharacterEncoding("utf-8");
			String name=request.getParameter("uname");
			String pwd=request.getParameter("upwd");
			
			if(name.equals("11")&& pwd.equals("22")){
				//跳转
				//重定向的方式跳转页面导致request生命周期结束，在loginok.jsp里使用request对象取不到数据
				//response.sendRedirect("loginok.jsp"); //这是重定向的写法	
				//请求转发的request生命周期还在，所以request对象里的数据不会丢失。
				//同时转发的新页面不会被记录，地址栏仍然显示showlogin.jsp
				request.getRequestDispatcher("loginok.jsp").forward(request, response);//请求转发的写法，后面跟一个forward表示向前跳转
			}else{
				//不跳
				out.print("login fail");
			}
		%>
</body>
</html>