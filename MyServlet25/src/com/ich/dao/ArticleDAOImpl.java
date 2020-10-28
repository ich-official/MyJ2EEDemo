package com.ich.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ich.entity.Article;
import com.ich.util.DBUtil;

/**
 * @author Ich
 * @summary None
 * @createTime 2020年10月28日下午5:54:12
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class ArticleDAOImpl implements IArticleDAO {

	/**
	 * 
	 */
	@Override
	public ArrayList<Article> queryAll() {
		String sql="select * from article";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Article> list=new ArrayList<Article>();
		try {
			conn=DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=DBUtil.query(pstmt);
			while(rs.next()) {
				Article a=new Article();
				a.setId(rs.getInt("Id"));
				a.setTitle(rs.getString("title"));
				a.setMainText(rs.getString("maintext"));
				a.setClickTime(rs.getInt("clicktime"));
				list.add(a);
			}
			System.out.println("list count="+list.size());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
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

}
