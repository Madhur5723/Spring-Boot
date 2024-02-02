package com.demo.AddressService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.AddressService.entity.Address;
import com.demo.AddressService.entity.AddressResponse;
import com.demo.AddressService.repo.AddressRepositary;

@Service
public class AddressService {

	@Autowired
	private AddressRepositary repo;

	@Autowired
	private ModelMapper modelMapper;

	
	public AddressResponse findUserById(int userId) {
		Address address = repo.findAddressByUserId(userId);
		AddressResponse addressResponse = modelMapper.map(address,AddressResponse.class);
		return addressResponse;
	}

}
