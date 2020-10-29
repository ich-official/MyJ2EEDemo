package com.ich.dao;

import java.sql.*;

import com.ich.entity.User;
import com.ich.util.DBUtil;

/**
 * @author Ich
 * @summary None
 * @createTime 2020��10��25������3:17:59
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class UserDAOImpl implements IUserDAO{
	
	/**
	   *   ��½��
	 * 	�����classNotFound�����Խ�jar���Ž�tomcat��װĿ¼�µ�lib��ɽ������
	 * 
	 */
	@Override
	public boolean login(User u)  {
		String sql="select * from user where Username=? && Pwd=?";
		ResultSet rs=null;
		boolean flag=false;
		try {
			Object[] params= {u.getUsername(),u.getPassword()};

			rs=DBUtil.executeQuery(sql,params);
			if(rs.next()) {
				flag=true;
			}else{
				flag=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				
				DBUtil.closeConnection();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return flag;
	}

	
	/**
	   * ע��
	 * 
	 * @param u
	 * @return
	 */
	@Override
	public int reg(User u) {
		int count=-1;
		String sql="insert into user(Username, Pwd) values(?,?) ";

		try {

			Object[] params= {u.getUsername(),u.getPassword()};
			count =DBUtil.executeUpdate(sql, params);
			DBUtil.closeConnection();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}


	@Override
	public int getCount(String sql) {
		int count=-1;
		try {
			count= DBUtil.getCount(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
