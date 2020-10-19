package com.bmart.shopping.usermgmt.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="USER_DTLS")
public class BmartUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer active;

    private String roles = "";

    private String permissions = "";

    public BmartUser(String username, String password, String roles, String permissions){
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

    protected BmartUser(){}

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", username=" + username + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + ", permissions=" + permissions + "]";
	}
    
    
}