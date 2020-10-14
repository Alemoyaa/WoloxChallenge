package com.challenge.controller;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.AlbumEntity;
import com.challenge.service.AlbumManagerService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/manager/albums")
@Transactional
public class AlbumManagerController {

	private AlbumManagerService service;

	public AlbumManagerController(AlbumManagerService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok().body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please try again later \": \"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id) {
		try {
			return ResponseEntity.ok().body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error. Please check the ID, and try again later \": \"" + e.getMessage() + "\"}");
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> post(@RequestBody AlbumEntity dto) {
		try {
			return ResponseEntity.ok().body(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
		}
	}

}
