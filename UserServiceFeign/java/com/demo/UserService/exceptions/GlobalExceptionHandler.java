package com.demo.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiRespoonse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiRespoonse respoonse = ApiRespoonse.builder().message(message)
		.RequestSuccess(true).output(false).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(respoonse,HttpStatus.NOT_FOUND);
		}
	

}
