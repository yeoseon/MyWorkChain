package bankware.finlab.myworkchain.server.service;

import java.math.BigDecimal;
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

import bankware.finlab.myworkchain.common.constant.DataSourceConstant;
import bankware.finlab.myworkchain.common.repository.WorkPlaceRepository;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequestFrom;
import bankware.finlab.myworkchain.server.dto.restapi.RestResponse;

@Service
public class CommonService {
	
	@Autowired
	WorkPlaceRepository workPlaceRepository;
	
	public RestResponse callPost(String rqst, String postfix) {
		
		String url = DataSourceConstant.REST_API_URL_TRANSACTION + postfix;
		
		RestTemplate restTemplate = new RestTemplate();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + DataSourceConstant.BEARER_API);
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> entity = new HttpEntity<String>(rqst, headers);
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		RestResponse response = restTemplate.postForObject(url, entity, RestResponse.class);
		
		return response;
		
	}
	
	public RestResponse callGet(String adrs, String postfix) { // get Balance일 때만 사용하므로, adrs 고정해둠
		
		String url = DataSourceConstant.REST_API_URL_WALLET + adrs + postfix;
		RestTemplate restTemplate = new RestTemplate();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + DataSourceConstant.BEARER_API);
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
	 * 시스템 년,월,일,시간 정보 (yyyy-MM-dd HH:mm:ss)
	 */
	public String getDate() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date time = new Date();
		
		String date = format.format(time);
		
		return date;
	}
	
	/*
	 * 시스템 년,월 정보(YYYYMM)
	 */
	public String getYearMonth(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		
		String yearMonth = format.format(date);
		return yearMonth;
	}
	
	/*
	 * 시스템 일 정보(DD)
	 */
	public String getDay(Date date) {
		
		SimpleDateFormat format = new SimpleDateFormat("dd");
		
		String day = format.format(date);
		return day;
	}
	
	public String bigDecimalToString(BigDecimal target) {
		
		return target.toString();
	}
	
	/*
	 * 위도/경도 변환(소숫점 6자리 -> * 100000)
	 */
	public BigDecimal multiple(BigDecimal target) {
		BigDecimal result;
		BigDecimal operator = new BigDecimal("100000");
		
		result = target.multiply(operator);
		
		return result;
	}
	
	/*
	 * 위도/경도 변환(정수 -> 소숫점 6자리)
	 */
	public BigDecimal divide(BigDecimal target) {
		BigDecimal result;
		BigDecimal operator = new BigDecimal("100000");
		
		result = target.divide(operator);
		
		return result;
	}
}
