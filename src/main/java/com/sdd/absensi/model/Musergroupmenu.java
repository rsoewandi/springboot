package com.sdd.absensi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Table
@Entity
@Data
public class Musergroupmenu {

	@Id
	private Long musergroupmenupk;

	@JsonManagedReference
	@OneToMany(mappedBy = "musergroupmenu")
	private List<Musergroup> musergroup;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "musergroupmenu")
	private List<Mmenu> mmenu;
}
