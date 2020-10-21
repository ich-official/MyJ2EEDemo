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
	// MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/ich_j2ee";
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    //自己数据库的帐密，默认都是root（自己设置的）
    static final String USER = "root";
    static final String PASS = "root";
    
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    public void connectQuery() {
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn =  DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 使用Statement查询...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String username = rs.getString("Username");
                String pwd = rs.getString("pwd");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", username: " + username);
                System.out.print(", pwd: " + pwd);
                System.out.print("\n");
            }
            // 完成后关闭，按实例化顺序从后往前关
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    //使用PreparedStatement
    public void connectQuery(String sql) {
    	try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn =  DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 使用PreparedStatement查询...");
           // String sql2;
           // sql2 = "select * from user ";	//?代表预编译，下面可以用pstmt.setXXX(index,value)来给?赋值
            //目前实践有几个错误的?写法，?大概不可用于表名位置，查询where后的条件、增删的value都好使
            //String s="select ? from user"
            //String s="select * from ?"
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 3);	//给sql中的?赋值，下标从1开始
            rs = pstmt.executeQuery();
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("Id");
                String username = rs.getString("Username");
                String pwd = rs.getString("pwd");
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", username: " + username);
                System.out.print(", pwd: " + pwd);
                System.out.print("\n");
            }
            // 完成后关闭，按实例化顺序从后往前关
            rs.close();
            pstmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(pstmt!=null) pstmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    public void connectUpdate() {
    	try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn =  DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 使用PreparedStatement查询...");
            String sql2;
            sql2 = "insert into user values (?,?,?) ";	//?代表预编译，下面可以用pstmt.setXXX(index,value)来给?赋值
            pstmt = conn.prepareStatement(sql2);
            pstmt.setInt(1, 5);	//给sql中的?赋值，下标从1开始
            pstmt.setString(2, "456");
            pstmt.setString(3, "888");

            int count =pstmt.executeUpdate();
            System.out.println("count"+count);
            // 完成后关闭，按实例化顺序从后往前关
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
