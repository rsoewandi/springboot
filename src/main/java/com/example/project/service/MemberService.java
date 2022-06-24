package com.example.project.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.exception.ValidationException;
import com.example.project.model.Member;
import com.example.project.repository.MemberRepository;
import com.example.project.request.MemberRequest;
import com.example.project.utils.UtilsOther;

@Service
public class MemberService {
	
	private final static Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	MemberRepository memberRepo;
	
	public HashMap<String, Object> getByUsername(MemberRequest request){
		HashMap<String, Object> response = new HashMap<String, Object>();
		Member member = memberRepo.findByUsername(request.getUsername());
		String errMsg;
		if(member == null) {
			errMsg = "Username not found";
			logger.info("checkInStaff = " + errMsg);
			throw new ValidationException(errMsg);
		}
		response.put("data", member);
		UtilsOther.successMap(response);
		return response;
	}
	
}
