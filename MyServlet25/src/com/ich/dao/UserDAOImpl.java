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
	 * 
	 * 
	 */
	@Override
	public boolean login(User u)  {
		String sql="select * from user where Username=? && Pwd=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try {

			//�����classNotFound�����Խ�jar���Ž�tomcat��װĿ¼�µ�lib��ɽ������
			conn=DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			rs=DBUtil.query(pstmt);
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
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();					
				}
				if(conn!=null) {
					conn.close();
				}
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
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {

			//�����classNotFound�����Խ�jar���Ž�tomcat��װĿ¼�µ�lib��ɽ������
			conn=DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			count=DBUtil.add(pstmt);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
}
