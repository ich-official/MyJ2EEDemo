package com.ich.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArticleCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ArticleCtrl() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		if(request.getParameter("ichaction").equals("add")){
			addArticle(request, response);

		}else if(request.getParameter("ichaction").equals("query")){
			queryArticle(request, response);
		}else if(request.getParameter("ichaction").equals("queryid")){
			queryArticleByid(request, response);
		}else if(request.getParameter("ichaction").equals("reply")){
			replyArticle(request, response);
		}else if(request.getParameter("ichaction").equals("rmain")){
			replyMain(request, response);
			
		}else if(request.getParameter("ichaction").equals("del")){
			delArticle(request, response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void testQueryArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void delArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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


	private void queryArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void addArticle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}



}
