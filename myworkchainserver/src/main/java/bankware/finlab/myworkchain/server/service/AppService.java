package bankware.finlab.myworkchain.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.common.repository.EmployeeRepository;
import bankware.finlab.myworkchain.server.dto.NewWorkRequest;
import bankware.finlab.myworkchain.server.dto.SendRewardRequest;

@Service
public class AppService {

	private final int VALUE_AMOUNT = 100; //TODO properties로 관리
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	WorkService workService;
	
	@Autowired
	RewardService rewardService;
	
	/*
	 * App 근무 기록 Service (근무기록(to Chain) + 근무기록(to DB) + 리워드 토큰 전송
	 * 오전 09:30분 이전에 출근 등록을 했을 경우,
	 * 퇴근 시, 출근 시간과 비교하여 8시간 이상 근무를 했을 경우 토큰을 지급한다.
	 * 토큰 지급 대상이 아닐 경우는 근무기록만 수행한다.
	 * NewWorkHistoryServiceRequest 
	 */
	public Boolean newWorkHistoryService(NewWorkRequest request) throws JsonProcessingException {
		
		Boolean result = false;
		
		//1. 근무 기록 (to DB) TODO
		Boolean newWorkToDBResponse = true;
		
		//2. 근무 기록 (to Chain)
		Boolean newWorkToChainResponse = workService.newWorkHistory(request);
		
		//3. 토큰 대상 여부 검사
		Boolean isSendReward = _isSendReward(request);
		
		//4. 토큰 대상일 경우 토큰 지급
		Boolean sendRewardResponse = false;
		if(isSendReward) {
			SendRewardRequest sendRewardRequest = new SendRewardRequest();
			sendRewardRequest.setGiverAddress(employeeRepository.findEmplAddressById(request.getId())); //직원이 속한 기업 Address 호출하여 Setting
			sendRewardRequest.setReceiverAddress(employeeRepository.findEmployeeById(request.getId()).getEmplAddress()); //직원 id를 통해 Address 호출하여 Setting
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
	
	/*
	 * 오전 09:30분 이전에 출근 등록을 했을 경우,
	 * 퇴근 시, 출근 시간과 비교하여 8시간 이상 근무를 했을 경우 토큰을 지급한다.
	 */
	private Boolean _isSendReward(NewWorkRequest request) {
		Boolean result = false;
		
		return result;
	}
}
