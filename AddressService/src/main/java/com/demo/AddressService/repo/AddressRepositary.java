package com.demo.AddressService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.AddressService.entity.Address;

@Repository
public interface AddressRepositary extends JpaRepository<Address, Integer> {
	
	@Query(nativeQuery = true ,value = "SELECT a.id,a.blood_group,a.state,a.user_id,a.phone_no FROM user u inner join address a on u.id=a.id where a.id=:userId")
	Address findAddressByUserId(@Param("userId") int id);
}
