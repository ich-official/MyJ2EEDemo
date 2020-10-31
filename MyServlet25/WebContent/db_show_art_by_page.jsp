<%@page import="com.ich.entity.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ich.entity.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
  <tr>
 	<th>Id</th>
    <th>clicktime</th>
    <th>title</th>
    <th>mainText</th>
    <th>操作</th>
  </tr>


<!-- 使用Page实体类加载指定页码的article实体  -->
    <%
    	Page p=(Page)request.getAttribute("curPageInfo");
    	ArrayList<Article> artlist=new ArrayList<Article>();
  		if(p!=null){
 			artlist=p.getCurPageEntity();
 		}
  		for(int i =0;i<artlist.size();i++){		
    %>
    	<tr>
		  	<td><%=artlist.get(i).getId() %></td>
		    <td><%=artlist.get(i).getClickTime() %></td>
		    <td><%=artlist.get(i).getTitle() %></td>
		    <td><%=artlist.get(i).getMainText() %></td>
		    <td><a href="ArticleCtrl?ichaction=del&Id=<%=artlist.get(i).getId() %>">删除</a></td>
	  	</tr>
    <%
  		}  
    %>
    
</table>

<a href="ArticleCtrl?ichaction=querypagebyid&curpage=1">首页</a>
<a href="ArticleCtrl?ichaction=querypagebyid&curpage=<%=p.getCurPage()-1 %>">上一页</a>
<a href="ArticleCtrl?ichaction=querypagebyid&curpage=<%=p.getCurPage()+1 %>">下一页</a>
<a href="ArticleCtrl?ichaction=querypagebyid&curpage=<%=p.getTotalPage() %>">尾页</a>


</body>
</html>