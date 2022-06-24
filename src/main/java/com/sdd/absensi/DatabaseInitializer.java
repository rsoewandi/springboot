package com.sdd.absensi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sdd.absensi.repository.MdeptRepository;
import com.sdd.absensi.repository.MshiftRepository;
import com.sdd.absensi.repository.MstaffRepository;
import com.sdd.absensi.security.CustomPasswordEncoder;

@Component
public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	MdeptRepository mdeptRepo;

	@Autowired
	MshiftRepository mshiftRepo;

	@Autowired
	MstaffRepository mstaffRepo;

	@Autowired
	CustomPasswordEncoder passwordEncode;

	@Override
	public void run(String... args) throws Exception {
//		String input = "Customer service excellence begins with you";
//		
//		String[] arrList = input.split(" ");
//		
//		for (String string : arrList) {
//			String reverseWord = new StringBuilder(string).reverse().toString();      //step 2
//			System.out.print(reverseWord + " ");
//		}
		String url="https://sandbox.partner.api.bri.co.id/v1/rdn/GetSaldoByPEID";
   	 RestTemplate rest = new RestTemplate();

		Map<String, String> map = new HashMap<String, String>();
        map.put("PEID","52655");
			
        HttpHeaders header = new HttpHeaders();
//	        header.set("Authorization","Bearer "+token);
	        header.set("Authorization","Bearer oTGpywYQmIRd9FrpFZBLzO23NFlZ");
      // header.set("Authenticate", token);
	   //header.add("token_type","Bearer");
        header.set("Accept", "*/*");
	    header.setContentType(MediaType.APPLICATION_JSON);
      // header.add ("Content-Type", "application/json; UTF-8");
       header.add("BRI-Signature" ,"X2wya6AcxCJhAamB/zFy/7FGNRSLSg+UGVmrf+oa0Hc=");
       header.add("BRI-Timestamp" ,"2020-12-29T06:32:15.145Z");	
//       header.add("BRI-Signature" ,signatureString);
//       header.add("BRI-TIMESTAMP " ,timestamp);	
       
       
       HttpEntity<Object> request = new HttpEntity<Object>(map, header);
//        HttpEntity<Object> response = rest.exchange(url, HttpMethod.POST,request,Object.class);
//        Object resp = rest.exchange(url, HttpMethod.POST,request,Object.class);
//		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) resp;
		
	}

}
