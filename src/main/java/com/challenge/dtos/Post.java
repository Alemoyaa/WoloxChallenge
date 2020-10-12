package com.challenge.dtos;

import com.challenge.common.CommonEntity;

public class Post extends CommonEntity{
	private String title;
	private String body;
	
	private long userId;

	public Post() {
		super();
	}

	public Post(String title, String body, long userId) {
		super();
		this.title = title;
		this.body = body;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
