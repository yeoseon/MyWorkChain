package bankware.finlab.myworkchain.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.server.dto.NewWorkRequest;
import bankware.finlab.myworkchain.server.dto.WorkHistoryRequest;
import bankware.finlab.myworkchain.server.dto.restapi.CheckStampInput;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequest;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequestFrom;
import bankware.finlab.myworkchain.server.dto.restapi.RestResponse;
import bankware.finlab.myworkchain.server.dto.restapi.WorkHistoryInput;
import bankware.finlab.myworkchain.server.vo.WorkHistory;

@Service
public class WorkService {

	private final static String POSTFIX_CHECK_STAMP = "checkStampV2";
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	EmployeeService employeeService;
	
	/*
	 * 근무 기록
	 */
	public Boolean newWorkHistory(NewWorkRequest request) throws JsonProcessingException  {
		
		RestRequest restRequest =_setNewWorkRequest(request);
		
		RestResponse response = commonService.callPost(commonService.objectToJson(restRequest), POSTFIX_CHECK_STAMP);

		return response.getResult();
	}
	
	private RestRequest _setNewWorkRequest(NewWorkRequest request) {
		
		RestRequest restRequest = new RestRequest();
		
		//from
		RestRequestFrom from = commonService.getFrom();
		restRequest.setFrom(from);
		
		//input
		CheckStampInput input = new CheckStampInput();
		input.set_userId(employeeService.getEmployeeInfoById(request.getId()).getWalletAddress());
		input.set_yearMon(commonService.getYearMonth());
		input.set_day(commonService.getDay());
		input.set_workCode(request.getWorkCode());
		input.set_latitude(commonService.floatToInteger(request.getLatitude()));
		input.set_longitude(commonService.floatToInteger(request.getLatitude()));
		input.set_workPlace(request.getWorkPlaceCode());
		
		restRequest.setInputs(input);
		
		return restRequest;
	}
	
	/*
	 * 근무 기록 조회
	 */
	public List<WorkHistory> getWorkHistory(WorkHistoryRequest request) throws JsonProcessingException {
		
		RestRequest restRequest =_setWorkHistoryInput(request);
		
		RestResponse response = commonService.callPost(commonService.objectToJson(restRequest), POSTFIX_CHECK_STAMP);
		//TODO : make workHistoryList;
		
		return _makeWorkHistoryList(response);
	}
	
	private RestRequest _setWorkHistoryInput(WorkHistoryRequest request) {
		RestRequest restRequest = new RestRequest();
		
		//from
		RestRequestFrom from = commonService.getFrom();
		
		restRequest.setFrom(from);
		
		//input
		WorkHistoryInput input = new WorkHistoryInput();
		input.set_userId(employeeService.getEmployeeInfoById(request.getId()).getWalletAddress());
		input.set_yearMon(request.getYearMonth());
		input.set_stday(request.getStartDay());
		input.set_edday(request.getEndDay());
		
		restRequest.setInputs(input);
		
		return restRequest;
	} 

	private List<WorkHistory> _makeWorkHistoryList(RestResponse response) {
		List<WorkHistory> workHistoryList = new ArrayList<WorkHistory>();
		
		return workHistoryList;
	}
}
