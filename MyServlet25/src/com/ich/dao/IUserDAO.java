package com.ich.dao;

import com.ich.entity.User;

/**
 * @author Ich
 * @summary 登陆注册接口
 * @createTime 2020年10月25日下午3:16:23
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public interface IUserDAO {
	public boolean login(User u);
	public int reg(User u);
	public int getCount(String sql);
}
