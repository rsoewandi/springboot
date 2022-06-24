package com.example.project;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.project.model.Member;
import com.example.project.repository.MemberRepository;
import com.example.project.security.CustomPasswordEncoder;

@Component
public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	CustomPasswordEncoder passwordEncode;
	
	@Autowired
	MemberRepository memberRepo;

	@Override
	public void run(String... args) throws Exception {
		if(memberRepo.count()==0) {
			Member member = new Member("Sample Member", "sample", passwordEncode.encode("samplepwd"), "", new Date(), "System");
			memberRepo.save(member);
		}
		
	}

}
