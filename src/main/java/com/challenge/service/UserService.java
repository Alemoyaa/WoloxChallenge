package com.challenge.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.challenge.common.CommonService;
import com.challenge.dtos.User;

@Service
public class UserService extends CommonService<User>{

	public UserService(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	public User[] getAllUsers(){
		return getAll(User[].class, get_url() + "users");
	}
	
	public User getUser(long id){
		return getOne(id, User.class, get_url() + "users/{id}");
	}
	
}
