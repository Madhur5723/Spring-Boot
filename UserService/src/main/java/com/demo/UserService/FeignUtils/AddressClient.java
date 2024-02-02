//package com.demo.UserService.FeignUtils;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.demo.UserService.entity.AddressResponse;
//
//
//@FeignClient(name="ADDRESS-SERVICE" ,url="http://localhost:8081/address-app/api/")
//public interface AddressClient {
//
//	@GetMapping("/address/{userId}")
//	public ResponseEntity<AddressResponse> getAddressByUserId(@PathVariable("userId") int id);
//}
