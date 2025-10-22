package com.trsystems.model.enums;

public enum UsersRoles {
	ADMIN("admin"),
	USER("user");
	
	private String role;
	
	UsersRoles(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
