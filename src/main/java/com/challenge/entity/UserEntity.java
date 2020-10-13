package com.challenge.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 2662137524246716715L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<PermitsEntity> permisos = new ArrayList<PermitsEntity>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<PermitsEntity> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<PermitsEntity> permisos) {
		this.permisos = permisos;
	}

}
