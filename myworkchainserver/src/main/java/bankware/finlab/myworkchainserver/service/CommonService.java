package bankware.finlab.myworkchainserver.service;

import java.nio.charset.Charset;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CommonService {

	public void sendPost(String targetUrl, Object rqst) throws RestClientException, JsonProcessingException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		restTemplate.postForEntity(targetUrl, objectToJson(rqst), String.class);
	}
	
	public String objectToJson(Object object) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(object);	
	}	
}
