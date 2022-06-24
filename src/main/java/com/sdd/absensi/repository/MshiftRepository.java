package com.sdd.absensi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdd.absensi.model.Mshift;

@Repository
public interface MshiftRepository extends CrudRepository<Mshift, Long>{
	
}
