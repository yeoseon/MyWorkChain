package bankware.finlab.myworkchain.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.server.dto.SendRewardRequest;
import bankware.finlab.myworkchain.server.dto.restapi.RestResponse;
import bankware.finlab.myworkchain.server.dto.restapi.TransferToUserInput;
import bankware.finlab.myworkchain.server.dto.restapi.TransferToUserRequest;

@Service
public class RewardService {

	
	private final static String POSTFIX_TRANSFER_TO_USER = "transfer2User";
	@Autowired
	CommonService commonService;
	
	/*
	 * 리워드 제공
	 */
	public Boolean sendReward(SendRewardRequest request) throws JsonProcessingException {
		
		TransferToUserRequest restRequest = _setSendRewardRequest(request);
		
		RestResponse response = commonService.callPost(commonService.objectToJson(restRequest), POSTFIX_TRANSFER_TO_USER);
		
		return response.getResult();
	}
	
	private TransferToUserRequest _setSendRewardRequest(SendRewardRequest request) {
		TransferToUserRequest restRequest = new TransferToUserRequest();
		
		//from
		restRequest.setFrom(request.getGiverAddress());
		
		//input
		TransferToUserInput input = new TransferToUserInput();
		input.setReceiverAddress(request.getReceiverAddress());
		input.setValueAmount(request.getValueAmount());
		
		restRequest.setInputs(input);
		
		return restRequest;
	}
}
