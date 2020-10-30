//-----------------------------------------------------------
//	Author: Ich
//  CreateTime: 2020年10月30日下午8:35:01
//  Version: 1.0.0
//  ProjectURL: https://github.com/ich-official/MyJ2EEDemoGit
//  Contact_Me: ich_official@163.com
//-----------------------------------------------------------

package com.ich.entity;

import java.util.ArrayList;

public class Page {
	private int curPage;	//当前页码
	private int pageSize;	//一页显示多少条数据
	private int totalPage;	//总共有多少页
	private int totalCount;	//总共有多少条数据
	private ArrayList<Article> curPageEntity;	//当前页的所有实体
	
	public Page() {
		pageSize=10;	//本demo暂时写死，一页显示10条
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
	
	//总页数=总数据条数 % 一页多少条==0 ？总页数：总页数+1
	//自动计算，无需赋值
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
