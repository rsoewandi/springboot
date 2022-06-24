package com.sdd.absensi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Table
@Entity
@Data
public class Musergroup {

	@Id
	private Long musergrouppk;

	@Column
	private String usergroupcode;

	@Column
	private String usergroupname;
	
	@Column
	private String usergroupdesc;
	
	@Column
	private String unitcode;
	
	@Column
	private Date lastupdated;
	
	@Column
	private String updatedby;  

	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
    private Muser muser;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Musergroupmenu musergroupmenu;
}
