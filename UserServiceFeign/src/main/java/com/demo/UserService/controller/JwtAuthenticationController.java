package com.demo.UserService.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.UserService.JWT.JwtHelper;
import com.demo.UserService.entity.JwtRequest;
import com.demo.UserService.entity.JwtResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class JwtAuthenticationController {

	private UserDetailsService userDetailsService;

	private AuthenticationManager manager;

	private JwtHelper helper;

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

		this.doAuthenticate(request.getUsername(), request.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.helper.generateToken(userDetails);

		JwtResponse response = JwtResponse.builder().jwtToken(token)
				.username(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	// authenticate the jwtRequest
	private void doAuthenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			manager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Credentials Invalid !!");
		}

	}
}
