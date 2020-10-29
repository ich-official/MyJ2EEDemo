package com.ich.dao;

import com.ich.entity.User;

/**
 * @author Ich
 * @summary ��½ע��ӿ�
 * @createTime 2020��10��25������3:16:23
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
