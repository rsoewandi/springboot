package com.sdd.absensi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdd.absensi.model.Mdept;

@Repository
public interface MdeptRepository extends CrudRepository<Mdept, Long>{
	
}
