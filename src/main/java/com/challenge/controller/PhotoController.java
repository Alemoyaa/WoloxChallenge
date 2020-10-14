package com.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.service.PhotoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/photos")
public class PhotoController {
	
	private PhotoService service;
	
	public PhotoController(PhotoService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAllPhoto());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please try again later \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getPhoto(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please check the ID, and try again later \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getAllPhotoForUser(@PathVariable long userId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAllPhotoForUser(userId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please check the ID, and try again later \": \"" + e.getMessage() + "\"}");
		}
	}
}
