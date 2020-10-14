package com.bmart.shopping.usermgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmart.shopping.product.model.Product;
import com.bmart.shopping.usermgmt.model.UserDetails;
import com.bmart.shopping.usermgmt.service.UserDetailService;

import antlr.StringUtils;

@RestController
public class UserDetailController {
    
	@Autowired
	UserDetailService userDetailService;
	
	@PostMapping("/addUser")
	public UserDetails saveUser(@RequestBody UserDetails user) {
//		if(user.getStatus()==null) {
//			throw new InvalidFieldException("user is req");
//		}
		return userDetailService.saveUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<UserDetails> saveUsers(@RequestBody List<UserDetails> users){
		return userDetailService.saveUsers(users);
	}
	@GetMapping("/users/{status}")
	public List<UserDetails> getUsersByStatus(@PathVariable String status){
		return userDetailService.getUsersByStatus(status);
	}
	
	/*
	 * @ExceptionHandler public String
	 * handleInvalidFieldException(InvalidFieldException exception) { return
	 * exception.getMessage(); }
	 */
}
