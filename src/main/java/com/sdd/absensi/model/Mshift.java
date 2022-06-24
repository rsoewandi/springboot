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
public class Mshift {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long mshiftpk;
	
	@Column
	private String shiftname;
	
	@Column
	private Date workintime;
	
	@Column
	private Date workouttime;
	
	@Column
	private Long loclong;
	
	@Column
	private Long loclat;
	
	@Column
	private Integer scopearea;
	
	@Column
	private Date lastupdated;
	
	@Column
	private String updatedby;

	@JsonBackReference
	@OneToOne(mappedBy = "mshift",cascade =  CascadeType.ALL)
    private Mstaff mstaff;

	public Mshift() {}
	public Mshift(Long mshiftpk, String shiftname, Date workintime, Date workouttime, Long loclong, Long loclat,
			Integer scopearea, Date lastupdated, String updatedby) {
		super();
		this.mshiftpk = mshiftpk;
		this.shiftname = shiftname;
		this.workintime = workintime;
		this.workouttime = workouttime;
		this.loclong = loclong;
		this.loclat = loclat;
		this.scopearea = scopearea;
		this.lastupdated = lastupdated;
		this.updatedby = updatedby;
	}
}