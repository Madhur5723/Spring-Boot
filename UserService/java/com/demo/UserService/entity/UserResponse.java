package com.demo.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
	private int id;
	private String name;
	private String email;
	private String location;
	private AddressResponse addressResponse;

}
