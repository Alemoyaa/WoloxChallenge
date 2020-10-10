package com.challenge.entity;

import com.challenge.common.CommonEntity;

public class Post extends CommonEntity{
	private String title;
	private String body;
	
	private User userId;

	public Post() {
		super();
	}

	public Post(String title, String body, User userId) {
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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
}
