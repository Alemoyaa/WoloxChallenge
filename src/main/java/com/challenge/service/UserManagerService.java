package com.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.entity.PermitsEntity;
import com.challenge.entity.UserEntity;
import com.challenge.repository.UserManagerRepository;

@Service
public class UserManagerService {

	private UserManagerRepository repository;

	public UserManagerService(UserManagerRepository repository) {
		this.repository = repository;
	}

	public UserEntity findById(long id) throws Exception {
		try {
			Optional<UserEntity> varOptional = repository.findById(id);
			if (varOptional.isPresent())
				return varOptional.get();
			else
				return null;
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}

	public UserEntity save(UserEntity entity) throws Exception {
		try {
			entity = repository.save(entity);
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public UserEntity updatePermitsUser(long id, PermitsEntity entity) throws Exception {
		try {

			if (repository.existsById(id) == false) {
				throw new Exception("No value present");
			}

			Optional<UserEntity> varOptional = repository.findById(id);

			for (PermitsEntity permit : varOptional.get().getPermisos()) {
				if (permit.getId() == entity.getId()) {
					permit.setRead(entity.isRead());
					permit.setWrite(entity.isWrite());
				}
			}

			UserEntity entitySave = varOptional.get();

			entitySave = repository.save(entitySave);
			return entitySave;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Iterable<UserEntity> findAllUserByPermits(long idAlbum, boolean checker) throws Exception {

		try {
			List<UserEntity> allUsers = repository.findAll();
			List<UserEntity> usersFind = new ArrayList<UserEntity>();

			allUsers.forEach((UserEntity user) -> {
				user.getPermisos().forEach((PermitsEntity permit) -> {
					
					if (checker) {
						if (permit.getAlbum().getId() == idAlbum && permit.isRead()) {
							usersFind.add(user);
						}
					} else {
						if (permit.getAlbum().getId() == idAlbum && permit.isWrite()) {
							usersFind.add(user);
						}
					}

				});
			});

			return usersFind;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
}
