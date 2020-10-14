package com.challenge.controller;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.PermitsEntity;
import com.challenge.service.PermitsManagerService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/manager/permits")
@Transactional
public class PermitsManagerController {

	private PermitsManagerService service;

	public PermitsManagerController(PermitsManagerService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.ok().body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("{\"message\": \"Error. Please try again later.\"}");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id) {
		try {
			return ResponseEntity.ok().body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> post(@RequestBody PermitsEntity dto) {
		try {
			return ResponseEntity.ok().body(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable int id, @RequestBody PermitsEntity dto) {
		try {
			return ResponseEntity.ok().body(service.update(id, dto));
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
		}
	}

}
