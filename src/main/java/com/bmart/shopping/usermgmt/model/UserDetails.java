package com.bmart.shopping.usermgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_DTLS")
public class UserDetails {
    @Id
    @GeneratedValue
	private long userId;
	private String username;
	private String password;
	private String status;
	
	
}
