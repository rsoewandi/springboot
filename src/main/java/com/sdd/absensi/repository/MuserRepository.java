package com.sdd.absensi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdd.absensi.model.Muser;

@Repository
public interface MuserRepository extends CrudRepository<Muser, Long>{

}
