package com.challenge.entity;

import com.challenge.common.CommonEntity;

public class Comment extends CommonEntity{

	private String name;
	private String email;
	private String body;
	
	private Post postId;

	public Comment() {
		super();
	}

	public Comment(String name, String email, String body, Post postId) {
		super();
		this.name = name;
		this.email = email;
		this.body = body;
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
	}
	
}
