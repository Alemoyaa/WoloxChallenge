package com.challenge.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 2662137524246716715L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@OneToMany(/*cascade = CascadeType.ALL, orphanRemoval = true*/mappedBy = "user")
	private Set<PermitsEntity> permisos = new HashSet<PermitsEntity>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<PermitsEntity> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<PermitsEntity> permisos) {
		this.permisos = permisos;
	}
	
	
}
