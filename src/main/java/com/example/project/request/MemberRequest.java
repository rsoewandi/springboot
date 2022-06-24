package com.example.project.request;

import io.swagger.annotations.ApiModelProperty;

public class MemberRequest {
	@ApiModelProperty(name = "Username" ,example = "Member001")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}