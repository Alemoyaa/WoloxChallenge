package com.challenge.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.challenge.entity.PermitsEntity;
import com.challenge.repository.PermitsManagerRepository;

@Service
public class PermitsManagerService {
	private PermitsManagerRepository repository;

	public PermitsManagerService(PermitsManagerRepository repository) {
		this.repository = repository;
	}
	
	public PermitsEntity update(long id, PermitsEntity entity) throws Exception {
		try {
			if (repository.existsById(id) == false) {
				throw new Exception("No value present");
			}
			entity = repository.save(entity);			
			return entity;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Iterable<PermitsEntity> findAll() throws Exception {
		try {
			return repository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public PermitsEntity findById(long id) throws Exception {
		try {
			Optional<PermitsEntity> varOptional = repository.findById(id);
			if (varOptional.isPresent())
				return varOptional.get();
			else
				return null;
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}
	
}
