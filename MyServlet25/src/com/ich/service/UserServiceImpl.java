package com.ich.service;

import com.ich.dao.IUserDAO;
import com.ich.dao.UserDAOImpl;
import com.ich.entity.User;

/**
 * @author Ich
 * @summary None
 * @createTime 2020��10��25������3:42:51
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class UserServiceImpl implements IUserService {

	IUserDAO userdao=new UserDAOImpl();
	
	@Override
	public boolean login(User u) {
		// TODO Auto-generated method stub
		return userdao.login(u);
	}

	@Override
	public int reg(User u) {
		//���ж����ݿ��Ƿ����н�ɫ��û����add
		if(userdao.login(u)) {
			return 0;
		}else {
			return userdao.reg(u);
		}
		
	}
	
	

}
