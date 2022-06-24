package com.sdd.absensi.request;

import io.swagger.annotations.ApiModelProperty;

public class CheckInAndOutRequest {
	@ApiModelProperty(name = "ID Staff" ,example = "staff001")
	private String staffid;
	@ApiModelProperty(name = "Longitude" ,example = "0.33233")
	private Double longitude;
	@ApiModelProperty(name = "Latitude" ,example = "0.4950")
	private Double latitude;

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
}