package com.ich.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ich
 * @summary servlet25�汾�Ŀ��Ʋ�
 * @createTime 2020��10��24������4:09:46
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class UserCtrl extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getParameter ��Ӧjsp���name��key����equals��Ӧjsp���value
		if(request.getParameter("ichaction").equals("login")) {
			System.out.println("login!");
		}else if (request.getParameter("ichaction").equals("reg")) {
			System.out.println("reg!");

		}else {
			System.out.println("none!");
		}
	}
}
