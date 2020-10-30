//-----------------------------------------------------------
//	Author: Ich
//  CreateTime: 2020��10��30������8:35:01
//  Version: 1.0.0
//  ProjectURL: https://github.com/ich-official/MyJ2EEDemoGit
//  Contact_Me: ich_official@163.com
//-----------------------------------------------------------

package com.ich.entity;

import java.util.ArrayList;

public class Page {
	private int curPage;	//��ǰҳ��
	private int pageSize;	//һҳ��ʾ����������
	private int totalPage;	//�ܹ��ж���ҳ
	private int totalCount;	//�ܹ��ж���������
	private ArrayList<Article> curPageEntity;	//��ǰҳ������ʵ��
	
	public Page() {
		pageSize=10;	//��demo��ʱд����һҳ��ʾ10��
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	/*
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	*/
	
	//��ҳ��=���������� % һҳ������==0 ����ҳ������ҳ��+1
	//�Զ����㣬���踳ֵ
	public int getTotalPage() {
		return totalPage;
	}
	/*
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	*/
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	}

	public ArrayList<Article> getCurPageEntity() {
		return curPageEntity;
	}

	public void setCurPageEntity(ArrayList<Article> curPageEntity) {
		this.curPageEntity = curPageEntity;
	}

	
}
