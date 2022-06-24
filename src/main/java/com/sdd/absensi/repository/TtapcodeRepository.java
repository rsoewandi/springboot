package com.sdd.absensi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdd.absensi.model.Tattend;
import com.sdd.absensi.model.Ttapcode;

@Repository
public interface TtapcodeRepository extends CrudRepository<Ttapcode, Long>{
	Ttapcode findByTapcode(String tapCode);
}
