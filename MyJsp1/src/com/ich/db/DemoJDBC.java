//-----------------------------------------------------------
//	Author: Ich
//  CreateTime: 2020-10-21 19:26:25
//  Version: 1.0.0
//  ProjectURL: https://github.com/ich-official/IchSaga
//  Contact_Me: ich_official@163.com
//-----------------------------------------------------------

package com.ich.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DemoJDBC {
	// MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ich_j2ee";
 
    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    //�Լ����ݿ�����ܣ�Ĭ�϶���root���Լ����õģ�
    static final String USER = "root";
    static final String PASS = "root";
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    public void connectQuery() {
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn =  DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʹ��Statement��ѯ...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String username = rs.getString("Username");
                String pwd = rs.getString("pwd");
    
                // �������
                System.out.print("ID: " + id);
                System.out.print(", username: " + username);
                System.out.print(", pwd: " + pwd);
                System.out.print("\n");
            }
            // ��ɺ�رգ���ʵ����˳��Ӻ���ǰ��
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    //ʹ��PreparedStatement
    public void connectQuery(String sql) {
    	try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn =  DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʹ��PreparedStatement��ѯ...");
           // String sql2;
           // sql2 = "select * from user ";	//?����Ԥ���룬���������pstmt.setXXX(index,value)����?��ֵ
            //Ŀǰʵ���м��������?д����?��Ų������ڱ���λ�ã���ѯwhere�����������ɾ��value����ʹ
            //String s="select ? from user"
            //String s="select * from ?"
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 3);	//��sql�е�?��ֵ���±��1��ʼ
            rs = pstmt.executeQuery();
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("Id");
                String username = rs.getString("Username");
                String pwd = rs.getString("pwd");
                // �������
                System.out.print("ID: " + id);
                System.out.print(", username: " + username);
                System.out.print(", pwd: " + pwd);
                System.out.print("\n");
            }
            // ��ɺ�رգ���ʵ����˳��Ӻ���ǰ��
            rs.close();
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(pstmt!=null) pstmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    public void connectUpdate() {
    	try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn =  DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʹ��PreparedStatement��ѯ...");
            String sql2;
            sql2 = "insert into user values (?,?,?) ";	//?����Ԥ���룬���������pstmt.setXXX(index,value)����?��ֵ
            pstmt = conn.prepareStatement(sql2);
            pstmt.setInt(1, 5);	//��sql�е�?��ֵ���±��1��ʼ
            pstmt.setString(2, "456");
            pstmt.setString(3, "888");

            int count =pstmt.executeUpdate();
            System.out.println("count"+count);
            // ��ɺ�رգ���ʵ����˳��Ӻ���ǰ��
            //rs.close();
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt!=null) 
                	pstmt.close();
            }catch(SQLException se2){
            	
            }
            try{
                if(conn!=null) 
                	conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    public void closeDB() {
    	try{
    		if(rs!=null) {
    			rs.close();
    		}
        	if(stmt!=null) {
        		stmt.close();
        	}
        	if(pstmt!=null) {
        		pstmt.close();
        	}
        	if(conn!=null) {
        		conn.close();
        	}
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
        	
        	rs=null;
        	stmt=null;
        	pstmt=null;
        	conn=null;
    	}

    }
}
