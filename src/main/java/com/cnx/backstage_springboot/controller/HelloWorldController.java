package com.cnx.backstage_springboot.controller;


import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnx.backstage_springboot.utility.ResponseHandler;

@RestController
public class HelloWorldController {

  

  
  @GetMapping("/hello")
	@PreAuthorize("hasAnyAuthority('user')")
	public ResponseEntity<Object> sayHello(Principal principal) {
		return ResponseHandler.generateResponse(HttpStatus.OK,  "Hello " + principal.getName() + "!!");
	}

	@GetMapping("/nonauth")
	public ResponseEntity<Object> sayAnonymous() {
		return ResponseHandler.generateResponse(HttpStatus.OK,  "Hello Anonymous!!");
	}
  
}
