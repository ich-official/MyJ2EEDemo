<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<%! String global_name=null; %>
	<%
		//通过cookie保存用户名的demo
		boolean cflag=false;
		
		request.setCharacterEncoding("utf-8");
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("uname")){
					cflag=true;
					global_name=cookies[i].getValue();
					out.println("cookie active");
				}else{
					cflag=false;
					out.println("cookie not active");

				}
			}
		}
	%>

	<form action="showlogin.jsp" method="post">
	<input type="text" name="uname" value=<%= global_name==null?"":global_name %>> 
	<input type="password" name="upwd"> 
	<input type="submit" value="login_Post">
	
	</form>
</body>
</html>