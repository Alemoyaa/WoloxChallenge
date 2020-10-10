package com.challenge.entity;

import com.challenge.common.CommonEntity;

public class Todo extends CommonEntity{
	private String title;
	private boolean completed;
	
	private long userId;

	public Todo() {
		super();
	}
	
	public Todo(String title, boolean completed, long userId) {
		super();
		this.title = title;
		this.completed = completed;
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
