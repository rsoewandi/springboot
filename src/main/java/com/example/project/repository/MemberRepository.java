package com.example.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer>{

	Member findByUsername(String username);
	
}
