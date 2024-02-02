package com.demo.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
	
	private int id;
	private String bloodGroup;
	private String state;
	private String phoneNo;

}
