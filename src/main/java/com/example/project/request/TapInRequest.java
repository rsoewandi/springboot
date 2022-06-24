package com.example.project.request;

import io.swagger.annotations.ApiModelProperty;

public class TapInRequest {
	@ApiModelProperty(name = "Tap Code" ,example = "zzzsdq41223-13yqhwe-323")
	private String tapcode;

	public String getTapcode() {
		return tapcode;
	}

	public void setTapcode(String tapcode) {
		this.tapcode = tapcode;
	}
	
}