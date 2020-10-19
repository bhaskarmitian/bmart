package com.bmart.shopping.usermgmt.model;

public class UserDetailsResponse {
	private Long id;

	private String username;

	private String password;

	private Integer active;

	private String roles = "";

	private String permissions = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "UserDetailsResponse [id=" + id + ", username=" + username + ", password=" + password + ", active="
				+ active + ", roles=" + roles + ", permissions=" + permissions + "]";
	}
	
	
}
