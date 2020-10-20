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
		String name=(String)session.getAttribute("uname");
		if(name==null){
			response.sendRedirect("slogin.jsp");
		}else{
			out.print(name);
		}
	
	%>


	welcome, <%=session.getAttribute("uname") %>
	
	
	
</body>
</html>