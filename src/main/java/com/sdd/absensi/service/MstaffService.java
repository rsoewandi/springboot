package com.sdd.absensi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdd.absensi.exception.ValidationException;
import com.sdd.absensi.model.Mdept;
import com.sdd.absensi.model.Mstaff;
import com.sdd.absensi.model.Tattend;
import com.sdd.absensi.model.Ttapcode;
import com.sdd.absensi.repository.MstaffRepository;
import com.sdd.absensi.repository.TattendRepository;
import com.sdd.absensi.repository.TtapcodeRepository;
import com.sdd.absensi.request.CheckInAndOutRequest;
import com.sdd.absensi.request.TapInRequest;
import com.sdd.absensi.utils.UtilsOther;

@Service
public class MstaffService {
	
	private final static Logger logger = LoggerFactory.getLogger(MstaffService.class);
	
	@Autowired
	MstaffRepository mstaffRepo;

	@Autowired
	TattendRepository tattendRepo;
	
	@Autowired
	TtapcodeRepository ttapcodeRepo;
	
	public HashMap<String, Object> checkInStaff(CheckInAndOutRequest request){
		HashMap<String, Object> response = new HashMap<String, Object>();
		Mstaff mstaff = mstaffRepo.findByStaffid(request.getStaffid());
		String errMsg;
		if(mstaff == null) {
			errMsg = "Staff Id not found";
			logger.info("checkInStaff = " + errMsg);
			throw new ValidationException(errMsg);
		}
		Tattend tattend = tattendRepo.findByStaffid(request.getStaffid());
		if(tattend!=null) {
			errMsg = "Staff Id already checkIn";
			logger.info("checkInStaff = " + errMsg);
			throw new ValidationException(errMsg);
		}
		
		Ttapcode ttapcode = new Ttapcode();
		
		ttapcode.setTapcode(UUID.randomUUID().toString());
		ttapcode = ttapcodeRepo.save(ttapcode);
		tattend = new Tattend(request.getStaffid(),new Date(),request.getLongitude(),request.getLatitude(),ttapcode);
		tattendRepo.save(tattend);

		response.put("tapCode", ttapcode.getTapcode());
		UtilsOther.successMap(response);
		return response;
	}
	
	public HashMap<String, Object> checkOutStaff(CheckInAndOutRequest request){
		Mstaff mstaff = mstaffRepo.findByStaffid(request.getStaffid());
		String errMsg;
		if(mstaff == null) {
			errMsg = "Staff Id not found";
			logger.info("checkOutStaff = " + errMsg);
			throw new ValidationException(errMsg);
		}
		Tattend tattend = tattendRepo.findByStaffid(request.getStaffid());
		if(tattend==null) {
			errMsg = "Staff Id not found";
			logger.info("checkOutStaff = " + errMsg);
			throw new ValidationException(errMsg);
		}
		
		tattend.setCheckout(new Date());
		tattend.setCheckoutlat(request.getLatitude());
		tattend.setCheckinlong(request.getLongitude());
		tattendRepo.save(tattend);
		HashMap<String, Object> response = new HashMap<String, Object>();
		UtilsOther.successMap(response);
		return response;
	}
	
	public HashMap<String, Object> tapIn(TapInRequest request){
		Ttapcode ttapcode = ttapcodeRepo.findByTapcode(request.getTapcode());
		String errMsg;
		if(ttapcode == null) {
			errMsg = "tap code not valid";
			logger.info("tapIn = " + errMsg);
			throw new ValidationException(errMsg);
		}
		
		Tattend tattend = tattendRepo.findByTtapcode(ttapcode);
		if(tattend==null) {
			errMsg = "tap code not found";
			logger.info("tapIn = " + errMsg);
			throw new ValidationException(errMsg);
		}
		
		if(tattend.getTapin()!=null) {
			errMsg = "staff already tap in";
			logger.info("tapIn = " + errMsg);
			throw new ValidationException(errMsg);
		}
		
		tattend.setTapin(new Date());
		tattendRepo.save(tattend);
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		UtilsOther.successMap(response);
		return response;
	}
	
	public HashMap<String, Object> reset(){
		tattendRepo.deleteAll();
		ttapcodeRepo.deleteAll();
		HashMap<String, Object> response = new HashMap<String, Object>();
		UtilsOther.successMap(response);
		return response;
	}
}
