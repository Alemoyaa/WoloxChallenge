package com.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.challenge.service.CommentService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/comments")
public class CommentController {
	
	private CommentService service;
	
	public CommentController(CommentService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getAllComments());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error in getAll \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getComment(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error in getOne \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getPostForName(@PathVariable String name) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findCommentsForName(name));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error in getPostForName \": \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/user/{idUser}")
	public ResponseEntity<?> getPostForUser(@PathVariable long idUser) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findCommentsForUser(idUser));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Error in getPostForName \": \"" + e.getMessage() + "\"}");
		}
	}
	
}
