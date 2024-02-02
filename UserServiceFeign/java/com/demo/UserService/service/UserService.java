package com.demo.UserService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.UserService.FeignUtils.AddressClient;
import com.demo.UserService.entity.AddressResponse;
import com.demo.UserService.entity.User;
import com.demo.UserService.entity.UserRequest;
import com.demo.UserService.entity.UserResponse;
import com.demo.UserService.exceptions.ResourceNotFoundException;
import com.demo.UserService.repo.UserRepositary;

@Service
public class UserService {

	@Autowired
	private UserRepositary repo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AddressClient addressClient;

	public UserResponse saveUser(UserRequest userRequest) {

		User user = modelMapper.map(userRequest, User.class);
		User savedUser = repo.save(user);
		UserResponse savedUserResponse = modelMapper.map(savedUser, UserResponse.class);
		System.out.println("User Created");
		return savedUserResponse;

	}

	public List<UserResponse> getAllUser() {
		List<User> users = repo.findAll();
		List<UserResponse> userResponses = users.stream().map(user -> modelMapper.map(user, UserResponse.class))
				.collect(Collectors.toList());

		return userResponses;

	}

	public UserResponse getUserById(int id) {

		User user = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Id Not Present " + id));

		UserResponse userResponse = modelMapper.map(user, UserResponse.class);

		
		ResponseEntity<AddressResponse> addressResponseEntity=addressClient.getAddressByUserId(id);
		
		AddressResponse addressResponse = addressResponseEntity.getBody();
		
		userResponse.setAddressResponse(addressResponse);
		return userResponse;
	}

}
