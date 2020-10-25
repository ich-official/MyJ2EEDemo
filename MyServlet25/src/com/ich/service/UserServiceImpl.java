package com.ich.service;

import com.ich.dao.IUserDAO;
import com.ich.dao.UserDAOImpl;
import com.ich.entity.User;

/**
 * @author Ich
 * @summary None
 * @createTime 2020年10月25日下午3:42:51
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
		//先判断数据库是否已有角色，没有再add
		if(userdao.login(u)) {
			return 0;
		}else {
			return userdao.reg(u);
		}
		
	}
	
	

}
