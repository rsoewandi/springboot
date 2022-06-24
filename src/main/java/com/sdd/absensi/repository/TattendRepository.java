package com.sdd.absensi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdd.absensi.model.Tattend;
import com.sdd.absensi.model.Ttapcode;

@Repository
public interface TattendRepository extends CrudRepository<Tattend, Long>{
	Tattend findByStaffid(String staffid);
	Tattend findByTtapcode(Ttapcode ttapcode);
}
