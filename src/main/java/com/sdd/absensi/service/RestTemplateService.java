package com.sdd.absensi.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sdd.absensi.response.ConnectorResponse;

@Service
public class RestTemplateService {

	@SuppressWarnings("unchecked")
	public <T> T callRestAPI(HttpHeaders httpHeader, Object request,Class<T> response,ConnectorResponse connector) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(request, httpHeader);
		Object resp = restTemplate.exchange(connector.getUrl(), connector.getMethod(), requestEntity, response);
		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) resp;
		return (T) responseEntity.getBody();
	}

}
