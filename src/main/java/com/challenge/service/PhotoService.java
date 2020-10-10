package com.challenge.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.challenge.common.CommonService;
import com.challenge.entity.Photo;

@Service
public class PhotoService extends CommonService<Photo>{

	public PhotoService(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	public Photo[] getAllPhoto(){
		return getAll(Photo[].class, get_url() + "photos");
	}
	
	public Photo getPhoto(long id){
		return getOne(id, Photo.class, get_url() + "photos/{id}");
	}
}
