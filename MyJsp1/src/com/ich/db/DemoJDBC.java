package com.ich.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdk.jfr.events.FileWriteEvent;

import java.sql.PreparedStatement;

/**
 * @author Ich
 * @summary JDBC demo
 * @createTime 2020-10-21 19:26:25
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
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

    public void connectClob() {

        try{
        	getConn();
        
            // ִ�в�ѯ
        	String sql="insert into myclob values(?,?,'')";	//�洢blob��sql    	
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1,4);
        	//Ϊ�洢clob��׼����������һ��ת������һ��txt�ļ�
        	InputStream in =new FileInputStream("H:\\JavaWorkspaceGit\\MyJ2EEDemoGit\\a.txt");
        	Reader reader=new InputStreamReader(in,"UTF-8");
        	pstmt.setCharacterStream(2, reader);	//��clobһ��ʹ��setCharacterStream
        	pstmt.executeUpdate();
            // ��ɺ�رգ���ʵ����˳��Ӻ���ǰ��
        	reader.close();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	try {
        		if(pstmt!=null) 
                	pstmt.close();
                if(conn!=null) 
                	conn.close();       		
        	}catch (Exception e) {
				// TODO: handle exception
			}
        }
    }
    
    public void getClob() {
    	try {
        	getConn();
        	String sql="select clobfile from myclob where Id=1";	//�洢blob��sql    	
        	pstmt = conn.prepareStatement(sql);
        	rs=pstmt.executeQuery();
        	while(rs.next()) {
        		Reader reader=rs.getCharacterStream("clobfile");	//ȡ��clob
        		Writer writer =new FileWriter("C:\\novel.txt");		//ʹ��IO����clobд��txt
        		char[] cache= new char[100];//������
        		int len=-1;
        		while((len=reader.read(cache))!=-1) {
        			writer.write(cache,0,len);
        			
        		}
        		writer.close();
        		reader.close();
        		
        	}
    	}catch (Exception e) {

    	}

    }
    
    public void connectBlob() {

        try{
        	getConn();
        
            // ִ�в�ѯ
        	String sql="insert into myclob values(?,'',?)";	//�洢blob��sql    	
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1,5);
        	//Ϊ�洢blob��׼����������һ���������ֽ�����һ���ļ�
        	File file=new File("H:\\JavaWorkspaceGit\\MyJ2EEDemoGit\\a.txt");
        	InputStream in =new FileInputStream(file);
        	pstmt.setBinaryStream(2, in,(int)file.length());	//��blob�ö������ֽ���
        	pstmt.executeUpdate();
            // ��ɺ�رգ���ʵ����˳��Ӻ���ǰ��
        	in.close();
            pstmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	try {
        		if(pstmt!=null) 
                	pstmt.close();
                if(conn!=null) 
                	conn.close();       		
        	}catch (Exception e) {
				// TODO: handle exception
			}
        }
    }
    
    public void getBlob() {
    	try {
        	getConn();
        	String sql="select blobfile from myclob where Id=5";	//�洢blob��sql    	
        	pstmt = conn.prepareStatement(sql);
        	rs=pstmt.executeQuery();
        	while(rs.next()) {
        		InputStream in=rs.getBinaryStream("blobfile");	//ȡ��Blob
        		OutputStream out=new FileOutputStream("C:\\music.txt");	//�����Ŀ��λ��
        		byte[] cache= new byte[100];//������
        		int len=-1;
        		while((len=in.read(cache))!=-1) {
        			out.write(cache,0,len);
        			
        		}
        		out.close();
        		in.close();
        		
        	}
    	}catch (Exception e) {

    	}

    }
    
    
    
    public void getConn() throws ClassNotFoundException, SQLException {
    	Class.forName(JDBC_DRIVER);
        System.out.println("�������ݿ�...");
        conn =  DriverManager.getConnection(DB_URL,USER,PASS);
    }
}
