package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserModel;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "User Rest Controller")
@RequestMapping("/api/v1")
public class UserService {
	
	private static List<UserModel> users;
	{
		users = new ArrayList<UserModel>();
		users.add(new UserModel("fname1", "laname1", "email1", "lang1"));
		users.add(new UserModel("fname2", "laname2", "email2", "lang2"));
		users.add(new UserModel("fname3", "laname3", "email3", "lang3"));
		users.add(new UserModel("fname4", "laname4", "email4", "lang4"));
	}
	
	@GetMapping("/users")
	public List<UserModel> getUsers() {
		return users;
	}
	
	@PostMapping(value = "/adduser")
	public ResponseEntity createUser(@RequestBody UserModel model) {
		users.add(model);
		return new ResponseEntity(model, HttpStatus.OK);
	}
	
	
	
}
