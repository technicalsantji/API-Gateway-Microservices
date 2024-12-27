package com.santji.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<APIResponse> handlerResourceNotFound(ResourceNotFound ex) {
		String message=ex.getMessage();
		APIResponse apiResponse = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
	
	return ResponseEntity.ok(apiResponse);
	}
}
