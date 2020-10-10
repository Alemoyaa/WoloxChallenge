package com.challenge.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.challenge.common.CommonService;
import com.challenge.entity.Album;

@Service
public class AlbumService extends CommonService<Album>{

	public AlbumService(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}
	
	public Album[] getAllAlbums(){
		return getAll(Album[].class, get_url() + "albums");
	}
	
	public Album getAlbum(long id){
		return getOne(id, Album.class, get_url() + "albums/{id}");
	}
	
	public Album[] getAllAlbumsForUser(long _userId){
		String url = get_url() + "albums?userId="+_userId+"";
		return getAll(Album[].class, url);
	}
}
