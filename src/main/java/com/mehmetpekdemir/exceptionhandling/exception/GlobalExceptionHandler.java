package com.mehmetpekdemir.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException) {
		log.error(notFoundException.getMessage(), notFoundException);
		final ApiErrorResponse response = new ApiErrorResponse(404, notFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException accessDeniedException) {
		log.error(accessDeniedException.getMessage(), accessDeniedException);
		final ApiErrorResponse response = new ApiErrorResponse(403, accessDeniedException.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> handleNullPointerException(NullPointerException nullPointerException) {
		log.error(nullPointerException.getMessage(), nullPointerException);
		final ApiErrorResponse response = new ApiErrorResponse(400, nullPointerException.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception) {
		log.error(exception.getMessage(), exception);
		final ApiErrorResponse response = new ApiErrorResponse(500, exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

}
