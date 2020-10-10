package com.challenge.entity;

import com.challenge.common.CommonEntity;

public class Photo extends CommonEntity{

	private String title;
	private String url;
	private String thumbnailUrl;
	
	private Album albumId;

	public Photo() {
		super();
	}

	public Photo(String title, String url, String thumbnailUrl, Album albumId) {
		super();
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public Album getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Album albumId) {
		this.albumId = albumId;
	}
}
