package com.sdd.absensi.model;

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

@Data
@Entity
@Table
public class Ttapcode {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long ttapcodepk;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "ttapcode",cascade =  CascadeType.ALL)
	private Tattend tattend;
	
	@Column
	private String tapcode;
}