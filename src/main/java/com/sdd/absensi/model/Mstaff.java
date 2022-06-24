package com.sdd.absensi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@Table
public class Mstaff {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long mstaffpk;
	
	@Column
	private String staffid;
	
	@Column
	private String password;
	
	@Column
	private String staffname;
	
	@Column
	private Date activedate;
	
	@Column
	private Date inactivedate;
	
	@Column
	private Date lastupdated;
	
	@Column
	private String updatedby;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mdeptfk", referencedColumnName = "mdeptpk")
	private Mdept mdept;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mshiftfk", referencedColumnName = "mshiftpk")
	private Mshift mshift;
	
	public Mstaff(){
		
	}

	public Mstaff(Long mstaffpk, String staffid, String password, String staffname, Date activedate, Date inactivedate,
			Date lastupdated, String updatedby,Mdept mdept, Mshift mshift) {
		super();
		this.mstaffpk = mstaffpk;
		this.staffid = staffid;
		this.password = password;
		this.staffname = staffname;
		this.activedate = activedate;
		this.inactivedate = inactivedate;
		this.lastupdated = lastupdated;
		this.updatedby = updatedby;
		this.mdept = mdept;
		this.mshift = mshift;
	}
	
	
}