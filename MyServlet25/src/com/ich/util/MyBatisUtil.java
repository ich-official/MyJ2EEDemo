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
 * @createTime 2020年11月3日下午4:02:12
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class MyBatisUtil {
	
	
	
	public static void TestMyBatis() throws IOException {
		Reader reader= Resources.getResourceAsReader("com/ich/xml/conf.xml");	//找到mybatis配置文件
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);	//创建一个sqlSessionFactory
		SqlSession session= sqlSessionFactory.openSession();	//打开数据库连接，获取SqlSession（=JDBC的connection）
		//----开始操作数据库----
		String statement="com.ich.xml.personMapper.queryPersonById";	//personMapper中namespace+id的组合
		Person p=session.selectOne(statement,2);	//根据配置文件，Object可以被转成Person（xml里设定的）
		System.out.println("name:"+p.getName());
		session.close();	//关闭连接
	}
	
}
