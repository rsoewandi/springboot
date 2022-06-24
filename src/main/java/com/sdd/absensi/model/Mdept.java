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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table
public class Mdept {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long mdeptpk;
	
	@Column
	private String deptcode;
	
	@Column
	private String deptname;
	
	@Column
	private Date lastupdated;
	
	@Column
	private String updatedby;

	@JsonBackReference
	@OneToOne(mappedBy = "mdept",cascade =  CascadeType.ALL)
    private Mstaff mstaff;

	public Mdept() {}
	public Mdept(Long mdeptpk, String deptcode, String deptname, Date lastupdated, String updatedby) {
		super();
		this.mdeptpk = mdeptpk;
		this.deptcode = deptcode;
		this.deptname = deptname;
		this.lastupdated = lastupdated;
		this.updatedby = updatedby;
	}
}