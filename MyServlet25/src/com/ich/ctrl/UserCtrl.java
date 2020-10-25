package com.ich.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ich.entity.User;
import com.ich.service.IUserService;
import com.ich.service.UserServiceImpl;

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
	
	IUserService userservice=new UserServiceImpl();
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getParameter ��Ӧjsp���name��key����equals��Ӧjsp���value
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("ichaction").equals("login")) {		
			System.out.println("login!");
			doLogin(request,response);
		}else if (request.getParameter("ichaction").equals("reg")) {
			System.out.println("reg!");
			doReg(request,response);
		}else {
			System.out.println("none!");
		}
	}
	
	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User u =new User();
		u.setUsername(request.getParameter("uname"));
		u.setPassword(request.getParameter("upwd"));
		boolean flag=userservice.login(u);
		RequestDispatcher dispatcher=request.getRequestDispatcher("db_login_result.jsp");
		PrintWriter writer=response.getWriter();
		if(flag) {			
			writer.println("��½�ɹ���");
			System.out.println("��½�ɹ���");
		}else {
			writer.println("��½ʧ�ܣ�");
			System.out.print("��½ʧ�ܣ�");

		}
		dispatcher.forward(request, response);
	}
	
	public void doReg(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User u =new User();
		u.setUsername(request.getParameter("uname"));
		u.setPassword(request.getParameter("upwd"));
		int count =userservice.reg(u);
		RequestDispatcher dispatcher=request.getRequestDispatcher("db_reg_result.jsp");
		PrintWriter writer=response.getWriter();
		if(count>0) {			
			writer.println("ע��ɹ���");
			System.out.println("ע��ɹ���");
		}else {
			writer.println("ע��ʧ�ܣ�");
			System.out.print("ע��ʧ�ܣ�");

		}
		dispatcher.forward(request, response);
	}	
		
}

