package com.sdd.absensi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Tattend {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long tattendpk;
	
	@Column
	private String staffid;
	
	@Column
	private Date checkin;
	
	@Column
	private Double checkinlong;
	
	@Column
	private Double checkinlat;
	
	@Column
	private Date tapin;
	
	@Column
	private Date checkout;
	
	@Column
	private Double checkoutlong;
	
	@Column
	private Double checkoutlat;

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
    private Ttapcode ttapcode;


	public Tattend(){}
	public Tattend(String staffid, Date checkin, Double checkinlong, Double checkinlat, Ttapcode ttapcode) {
		super();
		this.staffid = staffid;
		this.checkin = checkin;
		this.checkinlong = checkinlong;
		this.checkinlat = checkinlat;
		this.ttapcode = ttapcode;
	}
	
}	