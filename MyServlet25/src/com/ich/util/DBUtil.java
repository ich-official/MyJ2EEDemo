package com.ich.util;

import java.sql.*;


/**
 * @author Ich
 * @summary ��DBֱ�ӽ�������
 * @createTime 2020��10��25������3:03:05
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class DBUtil {
	//�����classNotFound�����Խ�jar���Ž�tomcat��װĿ¼�µ�lib��ɽ������
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ich_j2ee";
 
    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    //�Լ����ݿ�����ܣ�Ĭ�϶���root���Լ����õģ�
    static final String USERNAME = "root";
    static final String PWD = "root";
	private static Connection conn=null;
	private static PreparedStatement pstmt=null;
	private static ResultSet rs=null;
	private static Connection getConnection()  {
		/*
		if(conn==null) {
			try {
				ds=new ComboPooledDataSource();
				ds.setDriverClass(JDBC_DRIVER);
				ds.setJdbcUrl(DB_URL);
				ds.setUser(USERNAME);
				ds.setPassword(PWD);
				ds.setMaxPoolSize(40);
				//�������ӳ���С��������
				ds.setMinPoolSize(2);
				//�������ӳصĳ�ʼ������
				ds.setInitialPoolSize(10);
				//�������ӳصĻ���Statement�������
				ds.setMaxStatements(180);				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		try {
			conn=ds.getConnection();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		*/
		try {
			Class.forName(JDBC_DRIVER);  
	        conn=  DriverManager.getConnection(DB_URL,USERNAME,PWD);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
          
        // ������
        //System.out.println("�������ݿ�...");
		

    	return conn;

    }

    
	public static ResultSet executeQuery(String sql,Object[] params) throws SQLException {
		if(conn==null) {
			conn=getConnection();
		}
		getPstmt(sql, params);
		return pstmt.executeQuery();
		
	}
	
	public static int executeUpdate(String sql,Object[] params) throws SQLException {
		if(conn==null) {
			conn=getConnection();
		}
		getPstmt(sql, params);		
		return pstmt.executeUpdate();
	}
	
	public static int getCount(String sql) throws SQLException {
		rs=executeQuery(sql,null);
		int count=rs.getInt(1);
		return count;
	}
	
	
	private static PreparedStatement getPstmt(String sql,Object[] params) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		if(params!=null) {
			for(int i =0; i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	
	
	public static void closeConnection() throws SQLException {
		if(rs!=null	) {
			rs.close();
			rs=null;
		}
		if(pstmt!=null) {
			pstmt.close();
			pstmt=null;
		}
		if(conn!=null) {
			conn.close();
			conn=null;
		}
	}
	
}
