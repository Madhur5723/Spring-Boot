package com.demo.AddressService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.AddressService.entity.AddressResponse;
import com.demo.AddressService.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/address/{userId}")
	public ResponseEntity<AddressResponse> getAddressByUserId(@PathVariable("userId") int id) {
		AddressResponse addressResponse = null;
		addressResponse = addressService.findUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}

}
