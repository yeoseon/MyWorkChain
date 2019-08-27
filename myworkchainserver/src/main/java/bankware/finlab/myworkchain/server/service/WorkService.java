package bankware.finlab.myworkchain.server.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;
import bankware.finlab.myworkchain.server.dto.NewWorkHistoryToChainRequest;
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
	private final static String POSTFIX_STAMP_LIST = "stampListV2";
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	EmployeeService employeeService;

	/*
	 * 근무 기록(Chain)
	 */
	public Boolean newWorkHistory(NewWorkHistoryToChainRequest request) throws JsonProcessingException  {
		
		RestRequest restRequest =_setNewWorkRequest(request);
		
		RestResponse response = commonService.callPost(commonService.objectToJson(restRequest), POSTFIX_CHECK_STAMP);

		return response.getResult();
	}
	
	private RestRequest _setNewWorkRequest(NewWorkHistoryToChainRequest request) {
		
		RestRequest restRequest = new RestRequest();
		
		//from
		RestRequestFrom from = commonService.getFrom();
		restRequest.setFrom(from);
		
		//input
		CheckStampInput input = new CheckStampInput();
		input.set_userId(employeeService.getEmployeeInfoById(request.getUserId()).getEmplAddress());
		input.set_yearMon(commonService.getYearMonth(request.getDate()));
		input.set_day(commonService.getDay(request.getDate()));
		input.set_workCode(request.getWorkCode());
		input.set_latitude(commonService.floatToInteger(request.getLatitude()));
		input.set_longitude(commonService.floatToInteger(request.getLatitude()));
		input.set_workPlace(request.getWorkPlaceCode());
		
		restRequest.setInputs(input);
		
		return restRequest;
	}
	
	/*
	 * 근무 기록 조회(From Chain)
	 */
	//public List<WorkHistory> getWorkHistory(WorkHistoryRequest request) throws JsonProcessingException {
	public List<WorkHistoryEntity> getWorkHistory(WorkHistoryRequest request) throws JsonProcessingException {
		RestRequest restRequest =_setWorkHistoryInput(request);
		
		RestResponse response = commonService.callPost(commonService.objectToJson(restRequest), POSTFIX_STAMP_LIST);
		//TODO : make workHistoryList;
		
		return _makeWorkHistoryList(response, request);
	}
	
	private RestRequest _setWorkHistoryInput(WorkHistoryRequest request) {
		RestRequest restRequest = new RestRequest();
		
		//from
		RestRequestFrom from = commonService.getFrom();
		
		restRequest.setFrom(from);
		
		//input
		WorkHistoryInput input = new WorkHistoryInput();
		input.set_userId(employeeService.getEmployeeInfoById(request.getId()).getEmplAddress());
		input.set_yearMon(request.getYearMonth());
		input.set_stday(request.getStartDay());
		input.set_edday(request.getEndDay());
		
		restRequest.setInputs(input);
		
		return restRequest;
	} 

	//private List<WorkHistory> _makeWorkHistoryList(RestResponse response) {
	@SuppressWarnings("unchecked")
	private List<WorkHistoryEntity> _makeWorkHistoryList(RestResponse response, WorkHistoryRequest request) {
		List<WorkHistoryEntity> workHistoryList = new ArrayList<WorkHistoryEntity>();
		
		String userAddress = employeeService.getEmployeeInfoById(request.getId()).getEmplAddress();
		
		List<Object> stampKeyList = new ArrayList<Object>();
		stampKeyList = (List<Object>) response.getData().getRes().get(0);
		
		List<Object> stampTimeList = new ArrayList<Object>();
		stampTimeList = (List<Object>) response.getData().getRes().get(1);
		
		System.out.println("stampTimeList size : " + stampTimeList.size());
		
		int count=1;
		int stampNum = 0;
		for(Object stampKey : stampKeyList) {
			String _key = (String)stampKey;
			
//			String timestampstr = (String)stampTimeList.get(stampNum);
//			long timestamp = Long.parseLong(timestampstr);
//			LocalDateTime triggerTime =
//			        LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp*1000L), 
//			                                TimeZone.getDefault().toZoneId()); 
			
			
			String dateInstring = "";
			if(_key.substring(8,10).equals("01"))
				dateInstring = _key.substring(0,4)+"-"+_key.substring(4,6)+"-"+_key.substring(6,8)+"T09:30:00Z";
			else if (_key.substring(8,10).equals("02"))
				dateInstring = _key.substring(0,4)+"-"+_key.substring(4,6)+"-"+_key.substring(6,8)+"T18:30:00Z";
			
			//System.out.println("dateInstring : " + dateInstring);
			Instant instant = Instant.parse(dateInstring);
			LocalDateTime triggerTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
			//System.out.println("triggerTime : " + triggerTime);
			
			
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss");
//			String dateInstring = "";
//			if(_key.substring(8,10).equals("01"))
//				dateInstring = _key.substring(0,4)+"-"+_key.substring(4,6)+"-"+_key.substring(6,8)+" 09:30:00";
//			else if (_key.substring(8,10).equals("02"))
//				dateInstring = _key.substring(0,4)+"-"+_key.substring(4,6)+"-"+_key.substring(6,8)+" 18:30:00";
//			LocalDate triggerTime = LocalDate.parse(dateInstring, formatter);
			
			WorkHistoryEntity workHistoryEntity = WorkHistoryEntity.builder()
					.id(count)
					.userId(userAddress)
					.time(triggerTime)
//					.latitude()
//					.longitude()
					.workCode(_key.substring(8,10))
					.workPlaceCode(_key.substring(10,12))
				.build();
			
			workHistoryList.add(workHistoryEntity);
			count++;
			stampNum++;
		}
		
		//System.out.println("workHistoryList size : " + workHistoryList.size());
		return workHistoryList;
	}
}
