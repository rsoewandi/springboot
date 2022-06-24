package com.example.project.response;

import java.util.List;

public class TokenUserResponse {
	private String Authorization;
	private List<String> Roles;
	private List<String> Privileges;
	

	public List<String> getPrivileges() {
		return Privileges;
	}

	public void setPrivileges(List<String> privileges) {
		Privileges = privileges;
	}

	public String getAuthorization() {
		return Authorization;
	}

	public void setAuthorization(String authorization) {
		Authorization = authorization;
	}

	public List<String> getRoles() {
		return Roles;
	}

	public void setRoles(List<String> roles) {
		Roles = roles;
	}

	
}
