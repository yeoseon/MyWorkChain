package bankware.finlab.myworkchain.server.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.common.repository.EmployeeRepository;
import bankware.finlab.myworkchain.server.dto.NewWorkHistoryServiceInput;
import bankware.finlab.myworkchain.server.dto.NewWorkHistoryToChainRequest;
import bankware.finlab.myworkchain.server.dto.SendRewardRequest;
import bankware.finlab.myworkchain.server.vo.WorkPlace;

@Service
public class AppService {

	private final int VALUE_AMOUNT = 100; //TODO properties로 관리
	private final String START_WORK_CODE = "01";
	private final String END_WORK_CODE = "02";
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	WorkService workService;
	
	@Autowired
	RewardService rewardService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CompanyService companyService;
	
	/*
	 * App 근무 기록 Service (근무기록(to Chain) + 근무기록(to DB) + 리워드 토큰 전송
	 * 오전 09:30분 이전에 출근 등록을 했을 경우,
	 * 퇴근 시, 출근 시간과 비교하여 8시간 이상 근무를 했을 경우 토큰을 지급한다.
	 * TODO : 근무지와 현재 위/경도를 비교하는 것도 고려 해야함
	 * 토큰 지급 대상이 아닐 경우는 근무기록만 수행한다.
	 * NewWorkHistoryServiceRequest 
	 * TODO: result가 false시, 에러 메시지도 처리해야할 듯.
	 */
	public Boolean newWorkHistoryService(NewWorkHistoryServiceInput input) throws JsonProcessingException {
		
		Boolean result = false;
		
		NewWorkHistoryToChainRequest newWorkToChainRequest = _setRequest(input);
		//1. 근무 기록 (to DB) TODO
		Boolean newWorkToDBResponse = true;
		
		//2. 근무 기록 (to Chain)
		Boolean newWorkToChainResponse = workService.newWorkHistory(newWorkToChainRequest);
		
		//3. 토큰 대상 여부 검사 TODO
		Boolean isSendReward = _isSendReward(newWorkToChainRequest);
		
		//4. 토큰 대상일 경우 토큰 지급
		Boolean sendRewardResponse = false;
		if(isSendReward) {
			SendRewardRequest sendRewardRequest = new SendRewardRequest();
			sendRewardRequest.setGiverAddress(employeeRepository.findEmplAddressById(input.getId())); //직원이 속한 기업 Address 호출하여 Setting
			sendRewardRequest.setReceiverAddress(employeeRepository.findEmployeeById(input.getId()).getEmplAddress()); //직원 id를 통해 Address 호출하여 Setting
			sendRewardRequest.setValueAmount(VALUE_AMOUNT); 
			sendRewardResponse = rewardService.sendReward(sendRewardRequest);
		}
		else {
			sendRewardResponse = true;
		}
		
		if(newWorkToChainResponse == true && sendRewardResponse == true && newWorkToDBResponse == true) {
			result = true;
		}
		
		return result;
	}
	
	
	private NewWorkHistoryToChainRequest _setRequest(NewWorkHistoryServiceInput input) {
		NewWorkHistoryToChainRequest request = new NewWorkHistoryToChainRequest();
		
		request.setId(input.getId());
		request.setWorkPlaceCode(input.getWorkPlaceCode());
		request.setWorkCode(input.getWorkCode());
		request.setLatitude(input.getLatitude());
		request.setLongtitude(input.getLongtitude());
		
		Date date = new Date(); //시스템 시각
		request.setDate(date);
		
		return request;
	}
	
	/*
	 * 오전 09:30분 이전에 출근 등록을 했을 경우,
	 * 퇴근 시, 출근 시간과 비교하여 8시간 이상 근무를 했을 경우 토큰을 지급한다.
	 * TODO: result가 false시, 에러 메시지도 처리해야할 듯.
	 */
	private Boolean _isSendReward(NewWorkHistoryToChainRequest request) {
		
		Boolean result = false;

		// 해당 사용자의 근무지 정보 Get
		String userWorkPlaceCode = employeeService.getEmployeeInfoById(request.getId()).getWorkPlace();
		WorkPlace userWorkPlace = companyService.getWorkPlaceByCode(userWorkPlaceCode);
		
		// 입력받은 위/경도와 비교 TODO : 기준 정확히 정해서 구현해둘 것
//		if(userWorkPlace.getLatitude() == request.getLatitude() && userWorkPlace.getLongitude() == request.getLongtitude()) {
//			result = true;
//		}
//		else {
//			return false;
//		}
		
		if(START_WORK_CODE.equals(request.getWorkCode())) {
			//WorkCode가 '출근'인 경우
			//오전 09:30분 이전 출근 등록시 true
			Date date = request.getDate();
			
		}
		else if(END_WORK_CODE.equals(request.getWorkCode())) {
			//WorkCode가 '퇴근'인 경우
			//해당 날짜의 출근 시각 조회(UserId와 WorkCode(01), 오늘 날짜로 WorkStartYmd 조회)
			//8시간 이상 근무 했으면 true
			
//			Date startDate = request.get
		}
		
		return result;
	}
}
