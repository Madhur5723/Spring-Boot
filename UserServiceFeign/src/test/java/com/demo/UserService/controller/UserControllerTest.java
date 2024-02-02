package com.demo.UserService.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.UserService.entity.AddressResponse;
import com.demo.UserService.entity.User;
import com.demo.UserService.entity.UserRequest;
import com.demo.UserService.entity.UserResponse;
import com.demo.UserService.exceptions.ResourceNotFoundException;
import com.demo.UserService.repo.UserRepositary;
import com.demo.UserService.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.UserService.entity.UserRequest;
import com.demo.UserService.entity.UserResponse;
import com.demo.UserService.exceptions.ResourceNotFoundException;
import com.demo.UserService.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.UserService.controller.UserController;
import com.demo.UserService.entity.UserRequest;
import com.demo.UserService.entity.UserResponse;
import com.demo.UserService.service.UserService;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser() {
        // Mocking data
        UserRequest userRequest = new UserRequest(1, "John Doe", "john.doe@example.com", "Location");
        UserResponse mockUserResponse = new UserResponse(1, "John Doe", "john.doe@example.com", "Location", null);

        when(userService.saveUser(userRequest)).thenReturn(mockUserResponse);

        // Test the endpoint
        ResponseEntity<UserResponse> responseEntity = userController.saveUser(userRequest);

        // Verify the results
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(1, responseEntity.getBody().getId());
    }

    @Test
    public void testGetAllUser() {
        // Mocking data
        List<UserResponse> mockUserList = Arrays.asList(
                new UserResponse(1, "John Doe", "john.doe@example.com", "Location", null),
                new UserResponse(2, "Jane Doe", "jane.doe@example.com", "Location", null)
        );

        when(userService.getAllUser()).thenReturn(mockUserList);

       
        ResponseEntity<List<UserResponse>> responseEntity = userController.getAllUser();

        // Verify the results
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void testGetUserById() {
        // Mocking data
        int userId = 1;
        UserResponse mockUserResponse = new UserResponse(userId, "John Doe", "john.doe@example.com", "Location", null);

        when(userService.getUserById(userId)).thenReturn(mockUserResponse);

        ResponseEntity<UserResponse> responseEntity = userController.getUserById(userId);

        //results verify
        assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(userId, responseEntity.getBody().getId());
    }
}
