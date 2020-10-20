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
			request.setCharacterEncoding("utf-8");
			String name=request.getParameter("uname");
			String pwd=request.getParameter("upwd");
			System.out.println(name);
			
			//response.sendRedirect("loginok.jsp");	
			
			if(name.equals("11")&& pwd.equals("22")){
				//跳转
				session.setAttribute("uname", name);
				session.setAttribute("upwd", pwd);
				//下面这个非活动时间不可通过刷新网页去验证，request生命周期已结束会报空指针，但代码是正确的
				session.setMaxInactiveInterval(10);	//设置这个session最大的非活动有效时间，单位是秒
				request.getRequestDispatcher("sloginok.jsp").forward(request, response);//请求转发的写法，后面跟一个forward表示向前跳转
			}else{
				//不跳
				out.print("login fail");
			}
			
		%>
</body>
</html>