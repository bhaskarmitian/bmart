package com.bmart.shopping.usermgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmart.shopping.usermgmt.model.UserDetails;
import com.bmart.shopping.usermgmt.repository.UserDetailRepository;

@Service
public class UserDetailService {
    
	@Autowired
	UserDetailRepository userDetailRepository;
	
	public UserDetails saveUser(UserDetails user) {
		return userDetailRepository.save(user);
	}
	
	public List<UserDetails> saveUsers(List<UserDetails> users){
		return userDetailRepository.saveAll(users);
	}
	
	public List<UserDetails> getUsersByStatus(String status){
		return userDetailRepository.getUsersByStatus(status);
	}
}
