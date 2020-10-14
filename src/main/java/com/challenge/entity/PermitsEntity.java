package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "permits")
public class PermitsEntity implements Serializable{
	
	private static final long serialVersionUID = 4932910757761335606L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "album_id")
	private AlbumEntity album;

	@Column(name = "readUser")
	private boolean read;
	
	@Column(name = "writeUser")
	private boolean write;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public AlbumEntity getAlbum() {
		return album;
	}
	public void setAlbum(AlbumEntity album) {
		this.album = album;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
	}
	
	/*
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	@ManyToOne
	@MapsId("album_id")
	@JoinColumn(name = "ALBUM_ID")
	private AlbumEntity album;
	*/
	
		
}
