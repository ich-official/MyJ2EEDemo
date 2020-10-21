package com.ich.test;

import com.ich.db.DemoJDBC;

public class HelloWorld {
	public static void main(String[] args) {
		//System.out.println("hello world!");
		DemoJDBC jdbc=new DemoJDBC();
		//jdbc.connectDB();
		jdbc.connectQuery("select * from user where Id=?");
		//jdbc.connectUpdate();
		
		
		jdbc.closeDB();
	}
}
