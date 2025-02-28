package com.error.models;

public class User {
	
	private Long id;

	private String name;

	private String lastname;
	
	private Role role;
	
	public User() {
		super();
	}
	
	public User(Long id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	public User(Long id, String name, String lastname, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
//	public String getRoleName() {
//		return this.role.getName();
//	}
}
