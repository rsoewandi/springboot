package com.sdd.absensi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Table
@Entity
@Data
public class Mmenu {

	@Id
	private Long mmenupk;

	@Column
	private Integer menuorderno;

	@Column
	private String menugroup; 

	@Column
	private String menugroupicon; 

	@Column
	private String menusubgroup; 

	@Column
	private String menusubgroupicon; 

	@Column
	private String menuname; 

	@Column
	private String menuicon; 

	@Column
	private String menupath; 

	@Column
	private String menuparamname; 

	@Column
	private String menuparamvalue; 
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Musergroupmenu musergroupmenu;
}
