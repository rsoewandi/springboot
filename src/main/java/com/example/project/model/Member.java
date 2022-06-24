package com.example.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Member {

	@Id
	@Column
	private int memberpk;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private Date lastupdated;
	
	@Column
	private String updatedby;

	public Member() {}
	public Member(String name, String username, String password, String address, Date lastupdated, String updatedby) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.lastupdated = lastupdated;
		this.updatedby = updatedby;
	}
}