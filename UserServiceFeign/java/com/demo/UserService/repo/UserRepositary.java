package com.demo.UserService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.UserService.entity.User;

@Repository
public interface UserRepositary extends JpaRepository<User, Integer> {

}
