package com.sdd.absensi.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.base.Throwables;



@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);


//// for custom validation
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Map<String, Object>> handleSubmitValidationException(ValidationException e) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", HttpStatus.BAD_REQUEST);
		result.put("statusCode", HttpStatus.BAD_REQUEST.value());
		result.put("message", e.getMessage());
		ResponseEntity<Map<String, Object>> response = new ResponseEntity<Map<String, Object>>(result,
				HttpStatus.BAD_REQUEST);
		logger.error(e.toString(), Throwables.getStackTraceAsString(e));
//		WebServiceLog errorLog = new WebServiceLog();
//		errorLog.setCreateDate(new Date());
//		errorLog.setErrorMessage(e.getMessage());
//		errorLog.setLogLevel(ErrorLevel.ERROR.getText());
//		errorLog.setLogClass(e.getErrorClass());
//		errorLog.setLogLine(e.getErrorLine());
//		errorLogRepository.save(errorLog);
		return response;
	}
//
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest req, Exception e) {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("status", HttpStatus.BAD_REQUEST.value());
//		result.put("message", e.getMessage());
//		ResponseEntity<Map<String, Object>> response = new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
//		logger.error(Throwables.getStackTraceAsString(e));
//
//		WebServiceLog errorLog = new WebServiceLog();
//		errorLog.setCreateDate(new Date());
//		errorLog.setLogLevel(ErrorLevel.ERROR.getText());
//		
//		errorLog.setErrorMessage(e.getMessage());
//		errorLogRepository.save(errorLog);
//		return response;
//	}
}
