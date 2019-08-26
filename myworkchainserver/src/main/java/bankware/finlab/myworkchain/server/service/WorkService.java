package bankware.finlab.myworkchain.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bankware.finlab.myworkchain.server.common.RestResponse;
import bankware.finlab.myworkchain.server.dto.NewWorkRequest;
import bankware.finlab.myworkchain.server.vo.WorkHistory;

@Service
public class WorkService {

	/*
	 * 근무 기록
	 */
	public Boolean newWorkHistory(NewWorkRequest request)  {
		RestResponse response = new RestResponse();
		
		
		return response.getResult();
	}
	
	/*
	 * 근무 기록 조회
	 */
	public List<WorkHistory> getWorkHistory(String userId) {
		
		List<WorkHistory> workHistoryList = new ArrayList<WorkHistory>();
		
		return workHistoryList;
	}

}
