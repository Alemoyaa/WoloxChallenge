package com.challenge.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.challenge.common.CommonService;
import com.challenge.dtos.Album;

@Service
public class AlbumService extends CommonService<Album>{

	public AlbumService(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}
	
	public Album[] getAllAlbums() throws Exception{
		return getAll(Album[].class, get_url() + "albums");
	}
	
	public Album getAlbum(long id) throws Exception{
		return getOne(id, Album.class, get_url() + "albums/{id}");
	}
	
	public Album[] getAllAlbumsForUser(long _userId) throws Exception{
		String url = get_url() + "albums?userId="+_userId+"";
		return getAll(Album[].class, url);
	}
}
