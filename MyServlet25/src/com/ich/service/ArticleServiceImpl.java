package com.ich.service;

import java.util.ArrayList;

import com.ich.dao.ArticleDAOImpl;
import com.ich.dao.IArticleDAO;
import com.ich.entity.Article;

/**
 * @author Ich
 * @summary None
 * @createTime 2020年10月28日下午5:59:50
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class ArticleServiceImpl implements IArticleService {

	IArticleDAO dao=new ArticleDAOImpl();
	
	@Override
	public ArrayList<Article> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public int addArticle(Article a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Article queryArticleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean replyArticle(Article a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteArticle(Article a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dao.getCount();
	}

	@Override
	public ArrayList<Article> queryEntityByPage(int curPage, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryEntityByPage(curPage,pageSize);
	}

}
