package com.demomvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaRestController {

	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") int id){
		return ResponseEntity.ok(service.getOne(id));
	}
	
}
