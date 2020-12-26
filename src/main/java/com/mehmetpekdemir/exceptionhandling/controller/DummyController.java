package com.mehmetpekdemir.exceptionhandling.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmetpekdemir.exceptionhandling.exception.NotFoundException;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
public class DummyController {

	@PostMapping("/not-found")
	public ResponseEntity<?> handleNotFoundException() throws NotFoundException {
		throw new NotFoundException("Not Found Exception ! ", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/access-denied")
	public ResponseEntity<?> handleAccessDeniedException() throws AccessDeniedException {
		throw new AccessDeniedException("Access Denied Exception !");
	}

	@PostMapping("/null-pointer")
	public ResponseEntity<?> handleNullPointerException() throws NullPointerException {
		throw new NullPointerException("Null Pointer Exception !");
	}

	@PostMapping("/exception")
	public ResponseEntity<?> handleException() throws Exception {
		throw new Exception("Exception !");
	}

}
