package com.challenge.entity;

import com.challenge.common.CommonEntity;

public class Album extends CommonEntity{
	
	private String title;
	
	private long userId;

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(String title, long userId) {
		super();
		this.title = title;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
