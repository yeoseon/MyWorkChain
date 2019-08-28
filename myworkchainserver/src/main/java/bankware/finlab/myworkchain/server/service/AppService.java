package bankware.finlab.myworkchain.server.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.app.dto.WorkHistoryDto;
import bankware.finlab.myworkchain.app.service.WorkHistoryService;
import bankware.finlab.myworkchain.common.constant.DataSourceConstant;
import bankware.finlab.myworkchain.common.constant.WorkHistoryConstant;
import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;
import bankware.finlab.myworkchain.common.entity.WorkPlaceEntity;
import bankware.finlab.myworkchain.common.repository.EmployeeRepository;
import bankware.finlab.myworkchain.server.dto.SendRewardRequest;

@Service
public class AppService {
	
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
	
	@Autowired
	WorkHistoryService workHistoryService;
	
	@Autowired
	CommonService commonService;
	
	/*
	 * App 근무 기록 Service (근무기록(to Chain) + 근무기록(to DB) + 리워드 토큰 전송
	 * 오전 09:30분 이전에 출근 등록을 했을 경우,
	 * 퇴근 시, 출근 시간과 비교하여 8시간 이상 근무를 했을 경우 토큰을 지급한다.
	 * TODO : 근무지와 현재 위/경도를 비교하는 것도 고려 해야함
	 * 토큰 지급 대상이 아닐 경우는 근무기록만 수행한다.
	 * NewWorkHistoryServiceRequest 
	 * TODO: result가 false시, 에러 메시지도 처리해야할 듯.
	 */
	public Boolean newWorkHistoryService(WorkHistoryDto input) throws JsonProcessingException, ParseException {
		
		//TODO : Boolean으로 뱉어주지 말고, Response 처리
		
		//시스템 시각 Setting
		Date time = new Date(); 
		input.setTime(time);
		
		//입력받은 input의 위/경도 소수점 6자리 절사
		input.setLatitude(commonService.setScale(input.getLatitude()));
		input.setLongitude(commonService.setScale(input.getLongitude()));
		
		Boolean result = false;
		
		//1. 근무 기록 (to DB) TODO
//		WorkHistoryEntity workHistoryDbItem = workHistoryService.newWorkHistoryToDB(input); 
//		Boolean newWorkToDBResponse = true; // TODO: DB등록 잘 되었는지 처리
		
//		//2. 근무 기록 (to Chain)
		Boolean newWorkToChainResponse = workService.newWorkHistoryToChain(input);
//		
//		//3. 토큰 대상 여부 검사 TODO
//		Boolean isSendReward = _isSendReward(input);
//		
//		//4. 토큰 대상일 경우 토큰 지급
//		Boolean sendRewardResponse = false;
//		if(isSendReward) {
//			SendRewardRequest sendRewardRequest = new SendRewardRequest();
//			sendRewardRequest.setGiverAddress(employeeRepository.findEmplAddressByUserId(input.getUserId())); //직원이 속한 기업 Address 호출하여 Setting
//			sendRewardRequest.setReceiverAddress(employeeRepository.findEmployeeByUserId(input.getUserId()).getEmplAddress()); //직원 id를 통해 Address 호출하여 Setting
//			sendRewardRequest.setValueAmount(DataSourceConstant.VALUE_AMOUNT); 
//			sendRewardResponse = rewardService.sendReward(sendRewardRequest);
//		}
//		else {
//			sendRewardResponse = true;
//		}
//		
//		if(newWorkToChainResponse == true && sendRewardResponse == true && newWorkToDBResponse == true) {
//			result = true;
//		}
		
		return true;
//		return result;
	}
	
	/*
	 * 오전 09:30분 이전에 출근 등록을 했을 경우,
	 * 퇴근 시, 출근 시간과 비교하여 8시간 이상 근무를 했을 경우 토큰을 지급한다.
	 * TODO: result가 false시, 에러 메시지도 처리해야할 듯.
	 */
	private Boolean _isSendReward(WorkHistoryDto request) throws ParseException {
		
		Boolean result = false;

		// 해당 사용자의 근무지 정보 Get
		String userWorkPlaceCode = employeeService.getEmployeeInfoById(request.getUserId()).getCurrentWorkplaceCode();
		WorkPlaceEntity userWorkPlace = companyService.getWorkPlaceByCode(userWorkPlaceCode);
		
		// 입력받은 위/경도와 비교 TODO : 기준 정확히 정해서 구현해둘 것
		if(userWorkPlace.getLatitude() == request.getLatitude() && userWorkPlace.getLongitude() == request.getLongitude()) {
			result = true;
		}
		else {
			return false; // 현재 위치는 근무지가 아닙니다.
		}
		
		if(WorkHistoryConstant.WORK_CODE_START.equals(request.getWorkCode())) {
			//WorkCode가 '출근'인 경우
			//오전 09:30분 이전 출근 등록시 true
			
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date = format.parse(request.getTime().toString());
			Date referenceDate = format.parse("09:30:00"); //오전 9시 30분
			
			int compare = referenceDate.compareTo(date); //date가 더 작아야 함. 즉 compare가 > 0
			
			if(compare >= 0) {
				result = true;
			}
			else {
				return false; // 오전 09시 30분이 지났습니다.
			}
		}
		else if(WorkHistoryConstant.WORK_CODE_END.equals(request.getWorkCode())) {
			//WorkCode가 '퇴근'인 경우
			//해당 날짜의 출근 시각 조회(UserId와 WorkCode(01), 오늘 날짜로 WorkStartYmd 조회)
			//8시간 이상 근무 했으면 true
			
//			Date startDate = request.get
		}
		
		return result;
	}
}
