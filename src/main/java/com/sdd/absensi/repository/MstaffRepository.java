package com.sdd.absensi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdd.absensi.model.Mstaff;

@Repository
public interface MstaffRepository extends CrudRepository<Mstaff, Long>{
	
	Mstaff findByStaffid(String staffId);
}
