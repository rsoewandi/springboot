package com.example.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.request.MemberRequest;
import com.example.project.service.MemberService;

@RestController
@RequestMapping(value="/api/example")
public class ExampleController {
	
	@Autowired
	private MemberService mstaffService;
	
	@PostMapping("/profile")
	public ResponseEntity<HashMap<String, Object>> checkIn(@RequestBody MemberRequest request){
		return new ResponseEntity<>(mstaffService.getByUsername(request), HttpStatus.OK);
	}
	
	
}
