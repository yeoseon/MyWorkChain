package bankware.finlab.myworkchain.server.service;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bankware.finlab.myworkchain.common.repository.WorkPlaceRepository;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequestFrom;
import bankware.finlab.myworkchain.server.dto.restapi.RestResponse;

@Service
public class CommonService {
	
	//TODO : properties 관리
	private static final String REST_API_URL_TRANSACTION = "https://api.luniverse.io/tx/v1.0/transactions/";
	private static final String REST_API_URL_WALLET = "https://api.luniverse.io/tx/v1.0/wallets/";
	private static final String BEARER_API = "XVgsnDtJLUTZhVh112swjeKyqGQDDgWAL2rJTtSdD2PZhsypjifapM8nFZVWCV2J";
	
	@Autowired
	WorkPlaceRepository workPlaceRepository;
	
	public RestResponse callPost(String rqst, String postfix) {
		
		String url = REST_API_URL_TRANSACTION + postfix;
		
		RestTemplate restTemplate = new RestTemplate();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + BEARER_API);
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> entity = new HttpEntity<String>(rqst, headers);
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		RestResponse response = restTemplate.postForObject(url, entity, RestResponse.class);
		
		return response;
		
	}
	
	public String testCallPost(String rqst, String postfix) {
		
		String url = REST_API_URL_TRANSACTION + postfix;
		
		RestTemplate restTemplate = new RestTemplate();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + BEARER_API);
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> entity = new HttpEntity<String>(rqst, headers);
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		RestResponse response = restTemplate.postForObject(url, entity, RestResponse.class);
		
		return "ok";
		
	}
	
	public RestResponse callGet(String adrs, String postfix) { // get Balance일 때만 사용하므로, adrs 고정해둠
		
		String url = REST_API_URL_WALLET + adrs + postfix;
		RestTemplate restTemplate = new RestTemplate();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + BEARER_API);
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		ResponseEntity<RestResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, RestResponse.class);
		
		return response.getBody();
	}
	
	public RestRequestFrom getFrom() {
		RestRequestFrom from = new RestRequestFrom();
		//TODO: properties 관리?
		from.setUserKey("APIAddress");
		from.setWalletType("LUNIVERSE");
		
		return from;
	}
	
	public String objectToJson(Object object) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(object);	
	}	
	
	/*
	 * 시스템 년,월 정보(YYYYMM)
	 */
	public String getYearMonth() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		
		Date time = new Date();
		
		String yearMonth = format.format(time);
		return yearMonth;
	}
	
	/*
	 * 시스템 일 정보(DD)
	 */
	public String getDay() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd");
		
		Date time = new Date();
		
		String day = format.format(time);
		return day;
	}
	
	/*
	 * 위도/경도 변환(소숫점 6자리 -> Integer)
	 */
	public Integer floatToInteger(float target) {
		Integer result = null;
		
		result = (int) (target * 100000);
		
		return result;
	}
	
	/*
	 * 위도/경도 변환(Integer -> 소숫점 6자리)
	 */
	public float integerToFloat(Integer target) {
		float result;
		
		result = target / 100000;
		
		return result;
	}
}
