package com.ich.entity;

/**
 * @author Ich
 * @summary None
 * @createTime 2020年10月28日下午5:49:43
 * @version 1.0.0
 * @ProjectURL https://github.com/ich-official/MyJ2EEDemoGit
 * @Contact_Me ich_official@163.com
 * @update None
 */
public class Article {
	private int id;
	private String title;
	private String mainText;
	private int clickTime;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}
	public int getClickTime() {
		return clickTime;
	}
	public void setClickTime(int clickTime) {
		this.clickTime = clickTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
