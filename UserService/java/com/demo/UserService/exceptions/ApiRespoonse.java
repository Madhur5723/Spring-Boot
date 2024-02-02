package com.demo.UserService.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiRespoonse {
	
	private String message;
	private Boolean RequestSuccess;
	private Boolean output;
	private HttpStatus status;

}
