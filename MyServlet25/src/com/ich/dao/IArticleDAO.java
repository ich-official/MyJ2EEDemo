package com.ich.dao;

import java.util.ArrayList;

import com.ich.entity.Article;

/**
 * @author Ich
 * @summary None
 * @createTime 2020年10月28日下午5:49:23
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public interface IArticleDAO {
	public ArrayList<Article> queryAll();
	public int addArticle(Article a);
	public Article queryArticleById(int id);
	public boolean replyArticle(Article a);
	public int deleteArticle(Article a);
	
}
