package com.ich.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ich.entity.Person;

/**
 * @author Ich
 * @summary None
 * @createTime 2020��11��3������4:02:12
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class MyBatisUtil {
	
	
	
	public static void TestMyBatis() throws IOException {
		Reader reader= Resources.getResourceAsReader("com/ich/xml/conf.xml");	//�ҵ�mybatis�����ļ�
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);	//����һ��sqlSessionFactory
		SqlSession session= sqlSessionFactory.openSession();	//�����ݿ����ӣ���ȡSqlSession��=JDBC��connection��
		//----��ʼ�������ݿ�----
		String statement="com.ich.xml.personMapper.queryPersonById";	//personMapper��namespace+id�����
		Person p=session.selectOne(statement,2);	//���������ļ���Object���Ա�ת��Person��xml���趨�ģ�
		System.out.println("name:"+p.getName());
		session.close();	//�ر�����
	}
	
}
