<%@page import="com.ich.entity.Article"%>
<%@page import="com.ich.entity.Page"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show article</title>
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
  <!--   使用List的方式加载全部article -->
  <%
  	
  	ArrayList<Article> list=null;
  	if(request.getAttribute("articles")!=null){
  		 list=(ArrayList<Article>)request.getAttribute("articles");
  	}
  	for(int i=0; i<list.size();i++){
  		
  %>

  	<tr>
  	<td><%=list.get(i).getId() %></td>
    <td><%=list.get(i).getClickTime() %></td>
    <td><%=list.get(i).getTitle() %></td>
    <td><%=list.get(i).getMainText() %></td>
    <td><a href="ArticleCtrl?ichaction=del&Id=<%=list.get(i).getId() %>">删除</a></td>
  </tr>
  <% 
  
  	}
  	
  %>
    
    
</table>
<a href="ArticleCtrl?ichaction=querypagebyid&curpage=1">首页</a>
<a href="ArticleCtrl?ichaction=querypagebyid&curpage=1">>上一页</a>
<a href="ArticleCtrl?ichaction=querypagebyid&curpage=2">下一页</a>
<a href="ArticleCtrl?ichaction=querypagebyid&curpage=2">尾页</a>



</body>
</html>