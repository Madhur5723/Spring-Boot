package com.demo.UserService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.UserService.entity.UserRequest;
import com.demo.UserService.entity.UserResponse;
import com.demo.UserService.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logInfo=LoggerFactory.getLogger(UserController.class);

	// saveUser
	@PostMapping("/")
	public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
		UserResponse userResponse = userService.saveUser(userRequest);
        logInfo.info("User saved successfully. UserId: {}", userResponse.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserResponse>> getAllUser() {
		List<UserResponse> userDetails = userService.getAllUser();
        logInfo.info("Retrieved all users. User count: {}", userDetails.size());

		logInfo.info("USER LOGIN IS ENABLE");

		return ResponseEntity.status(HttpStatus.FOUND).body(userDetails);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") int id)
	{
		UserResponse userReceived =userService.getUserById(id);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(userReceived);

	}

}
