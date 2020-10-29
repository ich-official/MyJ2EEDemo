package com.ich.ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ich.entity.Article;
import com.ich.service.ArticleServiceImpl;
import com.ich.service.IArticleService;


public class ArticleCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IArticleService service=new ArticleServiceImpl();
 
    public ArticleCtrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("article ok");
		if(request.getParameter("ichaction").equals("add")){
			addArticle(request, response);
		}else if(request.getParameter("ichaction").equals("querypagebyid")){
			queryPageById(request, response);
		}else if(request.getParameter("ichaction").equals("queryid")){
			queryArticleByid(request, response);
		}else if(request.getParameter("ichaction").equals("reply")){
			replyArticle(request, response);
		}else if(request.getParameter("ichaction").equals("rmain")){
			replyMain(request, response);
			
		}else if(request.getParameter("ichaction").equals("del")){
			delArticle(request, response);
		}else if(request.getParameter("ichaction").equals("queryall")){
			//²éÑ¯ËùÓÐarticle
			queryAllArticle(request, response);
		}
	
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



	private void delArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("del!");
	}


	private void replyMain(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void replyArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void queryArticleByid(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void queryPageById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("query Page By Id");
		int curPage=Integer.parseInt(request.getParameter("curpage"));
		ArrayList<Article> list=service.queryEntityByPage(curPage);
		request.setAttribute("articles", list);
		request.getRequestDispatcher("dbshowall.jsp").forward(request, response);

	}


	private void addArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void queryAllArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("query all");
		ArrayList<Article> list=service.queryAll();
		request.setAttribute("articles", list);
		request.getRequestDispatcher("dbshowall.jsp").forward(request, response);
	}

}
