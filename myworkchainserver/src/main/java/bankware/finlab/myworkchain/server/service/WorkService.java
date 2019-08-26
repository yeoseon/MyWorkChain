package bankware.finlab.myworkchain.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.server.dto.NewWorkRequest;
import bankware.finlab.myworkchain.server.dto.restapi.CheckStampInput;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequest;
import bankware.finlab.myworkchain.server.dto.restapi.RestRequestFrom;
import bankware.finlab.myworkchain.server.dto.restapi.RestResponse;
import bankware.finlab.myworkchain.server.vo.WorkHistory;

@Service
public class WorkService {

	private final static String POSTFIX_CHECK_STAMP = "checkStampV2";
	
	CommonService commonService;
	
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
		RestRequestFrom from = new RestRequestFrom();
		
		//TODO: properties 관리?
		from.setUserKey("APIAddress");
		from.setWalletType("LUNIVERSE");
		
		restRequest.setFrom(from);
		
		CheckStampInput input = new CheckStampInput();
		input.set_userId(request.getId());
		input.set_yearMon(commonService.getYearMonth());
		input.set_day(commonService.getDay());
		input.set_workCode(request.getWorkCode());
		input.set_latitude(commonService.floatToInteger(request.getLatitude()));
		input.set_longitude(commonService.floatToInteger(request.getLatitude()));
		
		restRequest.setInputs(input);
		
		return restRequest;
	}
	
	/*
	 * 근무 기록 조회
	 */
	public List<WorkHistory> getWorkHistory(String userId) {
		
		List<WorkHistory> workHistoryList = new ArrayList<WorkHistory>();
		
		return workHistoryList;
	}

}
