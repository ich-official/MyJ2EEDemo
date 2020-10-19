<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
			//get方式防止乱码的方式是在tomcat的server.xml里Connector标签下新增URIEncoding="utf-8"
			request.setCharacterEncoding("UTF-8");	//post方式的转码，防乱码
			String name=request.getParameter("uname");	//取reg.jsp里name叫“uname”的value值
			String pwd=request.getParameter("upwd");
			//取reg.jsp里name叫“uhobbies”的value值，可以有多个
			String[] hobbies=request.getParameterValues("uhobbies");

		%>
		
		<%="name="+name %>
		<%="pwd="+pwd %>
		<%
			if(hobbies!=null){
				for(int i =0;i<hobbies.length;i++){
					out.print(hobbies[i]+"&nbsp");
				}
			}
		%>
</body>
</html>