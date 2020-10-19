package com.bmart.shopping.usermgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bmart.shopping.usermgmt.model.BmartUser;
import com.bmart.shopping.usermgmt.model.UserPrincipal;
import com.bmart.shopping.usermgmt.repository.UserRepository;

@Service
public class UserPrincipleService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      BmartUser user=userRepository.findByUsername(username);
      UserPrincipal userPrincipal=new UserPrincipal(user);
	  return userPrincipal;
	}

}
