<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show cookie</title>
</head>
<body>
		<%
			request.setCharacterEncoding("utf-8");
			Cookie[] cookies=request.getCookies();
			if(cookies!=null){
				for(int i =0;i<cookies.length;i++){
					out.print(cookies[i].getName());
					out.print(cookies[i].getValue());
					out.print("<br/>");
					
				}
			}
		
		%>
</body>
</html>