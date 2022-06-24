package com.sdd.absensi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Table
@Entity
@Data
public class Muser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long muserpk;

	@JsonManagedReference
	@OneToOne(mappedBy = "muser",cascade =  CascadeType.ALL)
	private Musergroup musergroup;

	@Column
	private String userid;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private Date lastupdated;
	
	@Column
	private String updatedby;
}
