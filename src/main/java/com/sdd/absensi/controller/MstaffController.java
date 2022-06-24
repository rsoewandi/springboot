package com.sdd.absensi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdd.absensi.model.Mstaff;
import com.sdd.absensi.request.CheckInAndOutRequest;
import com.sdd.absensi.request.TapInRequest;
import com.sdd.absensi.service.MstaffService;

@RestController
@RequestMapping(value="/api/mstaff")
public class MstaffController {
	
	@Autowired
	private MstaffService mstaffService;
	
	@PostMapping("/checkin")
	public ResponseEntity<HashMap<String, Object>> checkIn(@RequestBody CheckInAndOutRequest request){
		return new ResponseEntity<>(mstaffService.checkInStaff(request), HttpStatus.OK);
	}
	
	@PostMapping("/checkout")
	public ResponseEntity<HashMap<String, Object>> checkOut(@RequestBody CheckInAndOutRequest request){
		return new ResponseEntity<>(mstaffService.checkOutStaff(request), HttpStatus.OK);
	}
	
	@PostMapping("/tapin")
	public ResponseEntity<HashMap<String, Object>> tapIn(@RequestBody TapInRequest request){
		return new ResponseEntity<>(mstaffService.tapIn(request), HttpStatus.OK);
	}
	
	@GetMapping("/reset")
	public ResponseEntity<HashMap<String, Object>> reset(){
		return new ResponseEntity<>(mstaffService.reset(),HttpStatus.OK);
	}
	
	
}
