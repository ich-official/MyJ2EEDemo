package com.ich.service;

import java.util.ArrayList;

import com.ich.entity.Article;

/**
 * @author Ich
 * @summary None
 * @createTime 2020年10月28日下午5:59:17
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public interface IArticleService {
	public ArrayList<Article> queryAll();
	public int addArticle(Article a);
	public Article queryArticleById(int id);
	public boolean replyArticle(Article a);
	public int deleteArticle(Article a);
	public int getCount();
	public ArrayList<Article> queryEntityByPage(int curPage,int pageSize);
}
