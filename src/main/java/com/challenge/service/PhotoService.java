package com.challenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.challenge.common.CommonService;
import com.challenge.dtos.Album;
import com.challenge.dtos.Photo;

@Service
public class PhotoService extends CommonService<Photo>{

	public PhotoService(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	public Photo[] getAllPhoto() throws Exception{
		return getAll(Photo[].class, get_url() + "photos");
	}
	
	public Photo getPhoto(long id) throws Exception{
		return getOne(id, Photo.class, get_url() + "photos/{id}");
	}
	
	public List<Photo> getAllPhotoForUser(long _userId) throws Exception{
		
		String url = get_url() + "albums?userId="+_userId+"";
		
		Album[] albumsUser = this.restTemplate.getForObject(url, Album[].class);
		
		Photo[] photos;
		
		List<Photo> photosUser = new ArrayList<Photo>();
		
		for (Album album : albumsUser) {
			
			url = get_url() + "albums/"+album.getId()+"/photos";
			
			photos = getAll(Photo[].class, url);
			
			photosUser.addAll(Arrays.asList(photos));
			
		}
		
		return photosUser;
	}
}
