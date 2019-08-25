package bankware.finlab.myworkchainserver.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.common.entity.EmployeeEntity;
import bankware.finlab.myworkchain.common.repository.EmployeeRepository;
import bankware.finlab.myworkchain.common.repository.WorkPlaceRepository;
import bankware.finlab.myworkchainserver.vo.Employee;

@Service
public class EmployeeService {

	//TODO : 상수들 Properties로 관리
	private static final String REST_API_URL = "https://api.luniverse.io/tx/v1.0/transactions/companyUserListV1";
	private static final String GET_EMPLOYEE_ADDRESS_API_POSTFIX = ""; //getEmployeeAddressList의 API PostFix
	private static final String BEARER_API = "XVgsnDtJLUTZhVh112swjeKyqGQDDgWAL2rJTtSdD2PZhsypjifapM8nFZVWCV2J";
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	WorkPlaceRepository workPlaceRepository;
	
	@Autowired 
	CommonService commonService;
	
	//TODO: 직원 목록 조회
	//Chain에서 직원 Address 목록 조회
	//Server에 있는 직원 Data와 Mapping
	public List<Employee> getEmployeeList(String compAddress) throws RestClientException, JsonProcessingException {

		List<String> emplAddressList = _getEmplAddressList(compAddress);
		List<EmployeeEntity> emplListData = employeeRepository.findAll();
		
		return _mappingEmployeeInfo(emplAddressList, emplListData);
	}
	
	private List<String> _getEmplAddressList(String compAddress) throws RestClientException, JsonProcessingException {
		List<String> emplAddressList = new ArrayList<String>();

		String testrqst = "{\n" + 
				"        \"from\": {\n" + 
				"                \"userKey\": \"APIAddress\",\n" + 
				"                \"walletType\": \"LUNIVERSE\"\n" + 
				"        },\n" + 
				"        \"inputs\": {\n" + 
				"                \"_companyId\": \"0x69f2d1bdc2430a3a067620f617fec3100b892d54\"\n" + 
				"        }\n" + 
				"}";
		
		//TODO : get list of employee address from chain
		String url = REST_API_URL + GET_EMPLOYEE_ADDRESS_API_POSTFIX;
//		Map<String, Object> rqst = new HashMap<>(); //TODO: Request 객체 생성
		
		RestTemplate restTemplate = new RestTemplate();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + BEARER_API);
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<String> entity = new HttpEntity<String>(testrqst, headers);
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
//		String[] resultList = restTemplate.postForObject(url, commonService.objectToJson(testrqst), String[].class);
		String response = restTemplate.postForObject(url, entity, String.class);
		
//		emplAddressList = Arrays.asList(resultList);

		return emplAddressList;
	}
	
	public void sendPost(String targetUrl, Object rqst) throws RestClientException, JsonProcessingException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		restTemplate.postForEntity(targetUrl, commonService.objectToJson(rqst), String.class);
	}
	
	private List<Employee> _mappingEmployeeInfo(List<String> emplAddressList, List<EmployeeEntity> emplListData) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		// 1. Server DB에 있는 직원 목록을 먼저 다 가져온 후 Mapping한다. 
		for(String emplAddress : emplAddressList) {
			Employee employee = new Employee();
			
			for(EmployeeEntity emplDataItem : emplListData) {
				if(emplAddress.equals(emplDataItem.getEmplAddress())) {
					 employee = Employee.builder()
										.name(emplDataItem.getEmplName())
										.department(emplDataItem.getDepartment())
										.position(emplDataItem.getPosition())
										.joinDate(emplDataItem.getJoinDate())
										.email(emplDataItem.getEmail())
										.phoneNumber(emplDataItem.getPhoneNumber())
										.workPlace(_getWorkPlaceName(emplDataItem.getCurrentWorkCode()))
										.walletAddress(emplDataItem.getEmplAddress())
										.build();
				}
			}
			employeeList.add(employee);
		}
		
		return employeeList;
	}
	
	private String _getWorkPlaceName(int workPlaceCode) {
		return workPlaceRepository.findWorkNameByWorkCode(workPlaceCode);
	}
	
	//TODO: 직원의 근무 이력 조회
}
