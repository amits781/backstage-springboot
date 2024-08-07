package com.cnx.backstage_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnx.backstage_springboot.service.DemoObjectsService;
import com.cnx.backstage_springboot.utility.ResponseHandler;

@RestController
public class CBController {

	@Autowired
	DemoObjectsService objectService;

  
	@GetMapping("/objects")
	public ResponseEntity<Object> getObjects() {
		return ResponseHandler.generateResponse(HttpStatus.OK,  objectService.getObjects());
	}
	
	@GetMapping("/objects-fallback")
	public ResponseEntity<Object> getObjectsFallback() {
		return ResponseHandler.generateResponse(HttpStatus.OK,  objectService.getObjectsFallback());
	}
  
}
