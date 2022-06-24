package com.example.project.utils;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

public final class UtilsOther {
	
	public static <T> void validationData(T data,Map<String, Object> result){
		if(data!=null) {
			result.put("success", true);
		}else {
			result.put("success", false);
		}
	}
	
	public static void successMap(Map<String, Object> result){
		result.put("status", HttpStatus.OK);
		result.put("statusCode", HttpStatus.OK.value());
	}
	
	public static <T> void validationDataList(List<T> data,Map<String, Object> result){
		if(data.size()>0) {
			result.put("success", true);
		}else {
			result.put("success", false);
		}
	}
}
