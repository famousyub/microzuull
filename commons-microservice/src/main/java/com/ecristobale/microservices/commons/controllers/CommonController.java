package com.ecristobale.microservices.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecristobale.microservices.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> list() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Optional<E> o = service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build(); // return 404
		}
		return ResponseEntity.ok().body(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody E entity) {
		E entityDB = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDB); // return 201
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build(); // return 204
	}
	
}
