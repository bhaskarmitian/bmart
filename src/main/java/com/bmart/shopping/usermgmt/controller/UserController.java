package com.bmart.shopping.usermgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmart.shopping.usermgmt.model.BmartUser;
import com.bmart.shopping.usermgmt.model.UserDetailsResponse;
import com.bmart.shopping.usermgmt.repository.UserRepository;

@RestController
@RequestMapping("/usermgmt")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("users")
	public ResponseEntity<List<UserDetailsResponse>> users(){
		// List<UserDetails> users = new ArrayList<UserDetails>();
		    List<BmartUser> customersAll = userRepository.findAll();
		    
		    List<UserDetailsResponse> responsedata = new ArrayList<>();
		    for (BmartUser user : customersAll) {
		    	//users.add(user);
		    	
		    	UserDetailsResponse usedata = new UserDetailsResponse();
		    	usedata.setId(usedata.getId());
		    	usedata.setUsername(user.getUsername());
		    	usedata.setPassword(user.getPassword());
		    	usedata.setPermissions(user.getPermissions());
		    	usedata.setRoles(user.getRoles());
		    	usedata.setActive(user.getActive());
		    	
		    	  responsedata.add(usedata);
		    }
		    
		   // responsedata.addAll(responsedata);
		  System.out.println("responsedata==> "+responsedata);
			ResponseEntity<List<UserDetailsResponse>> resp = new ResponseEntity<List<UserDetailsResponse>>(responsedata, HttpStatus.OK);
		    
		 return resp;
		 
		 
	}
	@GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

}
