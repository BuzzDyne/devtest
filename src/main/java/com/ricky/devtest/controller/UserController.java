package com.ricky.devtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ricky.devtest.model.CreateUserRequest;
import com.ricky.devtest.model.EditUserRequest;
import com.ricky.devtest.model.GetUserRequest;
import com.ricky.devtest.model.GetUserResponse;
import com.ricky.devtest.model.Response;
import com.ricky.devtest.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(
		path = "/api/user", 
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Response<String> create(@RequestBody CreateUserRequest req) {
		userService.create(req);
		 return Response.<String>builder().data("OK").build();
	}
	
	@GetMapping(
		path = "/api/user", 
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Response<GetUserResponse> get(@RequestBody GetUserRequest req) {
		GetUserResponse res = userService.get(req);
		
		return Response.<GetUserResponse>builder().data(res).build();
	}
	
	@PutMapping(
		path = "/api/user", 
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Response<GetUserResponse> get(@RequestBody EditUserRequest req) {
		GetUserResponse res = userService.update(req);
		
		return Response.<GetUserResponse>builder().data(res).build();
	}
	
	@DeleteMapping(
		path = "/api/user", 
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Response<String> create(@RequestBody GetUserRequest req) {
		userService.delete(req);
		 return Response.<String>builder().data("OK").build();
	}
}
