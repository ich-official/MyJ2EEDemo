package com.ich.service;

import com.ich.entity.User;

/**
 * @author Ich
 * @summary Service��ӿ�
 * @createTime 2020��10��25������3:41:57
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public interface IUserService {
	public boolean login(User u);
	
	public int reg(User u);
}
