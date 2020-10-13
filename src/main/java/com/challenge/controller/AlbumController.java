package com.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.service.AlbumService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/albums")
public class AlbumController {
	
	private AlbumService service;
	
	public AlbumController(AlbumService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAllAlbums());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error in getAll \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAlbum(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error in getOne \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getAllAlbumsForUser(@PathVariable long userId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAllAlbumsForUser(userId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error in getAllAlbumsForUser \": \"" + e.getMessage() + "\"}");
		}
	}
}
