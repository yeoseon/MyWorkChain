package bankware.finlab.myworkchain.server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.common.entity.EmployeeEntity;
import bankware.finlab.myworkchain.common.entity.WorkPlaceEntity;
import bankware.finlab.myworkchain.common.repository.EmployeeRepository;
import bankware.finlab.myworkchain.common.repository.WorkPlaceRepository;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequest;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequestFrom;
import bankware.finlab.myworkchain.server.dto.restapi.RestResponse;
import bankware.finlab.myworkchain.server.vo.Employee;

@Service
public class EmployeeService {

	//TODO : 상수들 Properties로 관리
	private static final String POSTFIX_COMPANY_USER_LIST = "companyUserListV1"; //getEmployeeAddressList의 API PostFix
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	WorkPlaceRepository workPlaceRepository;
	
	@Autowired 
	CommonService commonService;
	
	/*
	 * 회사 Address를 받아 직원 목록 조회
	 */
	public List<Employee> getEmployeeList(String compAddress) throws RestClientException, JsonProcessingException {

		//Chain에서 직원 Address 목록 조회
		//Server에 있는 직원 Data와 Mapping
		List<Object> emplAddressList = _getEmplAddressList(compAddress);
		List<EmployeeEntity> emplListData = employeeRepository.findAll();
		
		return _mappingEmployeeInfo(emplAddressList, emplListData);
	}
	
	/*
	 * 직원 ID를 받아 직원 정보 조회
	 */
	public Employee getEmployeeInfoById(String userId) {
		
		EmployeeEntity entity = employeeRepository.findEmployeeById(userId);
		
		Employee employee = Employee.builder()
	 			.id(entity.getId())
				.name(entity.getEmplName())
				.department(entity.getDepartment())
				.position(entity.getPosition())
				.joinDate(entity.getJoinDate())
				.email(entity.getEmail())
				.phoneNumber(entity.getPhoneNumber())
				.workPlace(commonService.getWorkPlaceName(entity.getCurrentWorkCode()))
				.walletAddress(entity.getEmplAddress())
				.build();
		
		return employee;
	}
	
	@SuppressWarnings("unchecked")
	private List<Object> _getEmplAddressList(String compAddress) throws RestClientException, JsonProcessingException {

		RestRequest restRequest = _setEmplAddressListRequest(compAddress);

		RestResponse response = commonService.callPost(commonService.objectToJson(restRequest), POSTFIX_COMPANY_USER_LIST);
		
		List<Object> emplAddressList = new ArrayList<Object>();
		emplAddressList = (List<Object>) response.getData().getRes().get(0);
		return emplAddressList; 
	}
	
	private RestRequest _setEmplAddressListRequest(String compAddress) {
		
		RestRequest restRequest = new RestRequest();
		
		//from
		RestRequestFrom from = commonService.getFrom();
		restRequest.setFrom(from);
		
		//input
		Map<String, Object> input = new HashMap<>();
		input.put("_companyId", compAddress);
		
		restRequest.setInputs(input);
		
		return restRequest;
	}
	private List<Employee> _mappingEmployeeInfo(List<Object> emplAddressList, List<EmployeeEntity> emplListData) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		// 1. Server DB에 있는 직원 목록을 먼저 다 가져온 후 Mapping한다. 
		for(Object emplAddress : emplAddressList) {
			Employee employee = new Employee();
			
			for(EmployeeEntity emplDataItem : emplListData) {
				if(emplAddress.equals(emplDataItem.getEmplAddress())) {
					 employee = Employee.builder()
							 			.id(emplDataItem.getId())
										.name(emplDataItem.getEmplName())
										.department(emplDataItem.getDepartment())
										.position(emplDataItem.getPosition())
										.joinDate(emplDataItem.getJoinDate())
										.email(emplDataItem.getEmail())
										.phoneNumber(emplDataItem.getPhoneNumber())
										.workPlace(commonService.getWorkPlaceName(emplDataItem.getCurrentWorkCode()))
										.walletAddress(emplDataItem.getEmplAddress())
										.build();
				}
			}
			employeeList.add(employee);
		}
		
		return employeeList;
	}
}
