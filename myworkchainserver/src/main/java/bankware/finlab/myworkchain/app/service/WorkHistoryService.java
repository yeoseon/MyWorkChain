package bankware.finlab.myworkchain.app.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchain.app.dto.WorkHistoryDto;
import bankware.finlab.myworkchain.common.constant.WorkHistoryConstant;
import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;
import bankware.finlab.myworkchain.common.repository.WorkHistoryRepository;

@Service
public class WorkHistoryService {
	
	@Autowired
	private WorkHistoryRepository workHistoryRepository;
	
	/**
	 * Work History 생성
	 * @param workHistoryDto
	 * @return WorkHistoryEntity
	 */
	public WorkHistoryEntity newWorkHistory(WorkHistoryDto workHistoryDto) {
		WorkHistoryEntity workHistoryEntity = WorkHistoryEntity.builder()
																	.userId(workHistoryDto.getUserId())
																	.workCode(WorkHistoryConstant.WORK_CODE_START)
																	.latitude(workHistoryDto.getLatitude())
																	.longitude(workHistoryDto.getLongitude())
																	.build();
		return workHistoryRepository.save(workHistoryEntity);
	}

	/**
	 * Work History 가져오기
	 * @param userId
	 * @param time
	 * @return
	 */
	public WorkHistoryEntity getWorkHistoryWithTime(String userId, Timestamp time) {
		return workHistoryRepository.findWorkHistoryByUserIdAndTime(userId, time);
	}
	
	/**
	 * Work History 목록 가져오기
	 * @param userId
	 * @return
	 */
	public List<WorkHistoryEntity> getWorkHistoryList(String userId) {
		return workHistoryRepository.findWorkHistoryByUserId(userId);
	}
	
	/**
	 * Work History 수정
	 * @param workHistoryDto
	 * @return WorkHistoryEntity
	 */
	public WorkHistoryEntity modifyWorkHistory(WorkHistoryDto workHistoryDto) {
		WorkHistoryEntity oldWorkHistoryEntity = getWorkHistoryWithTime(workHistoryDto.getUserId(), workHistoryDto.getTime());
		WorkHistoryEntity workHistoryEntity = WorkHistoryEntity.builder()
																.id(oldWorkHistoryEntity.getId())
																.userId(oldWorkHistoryEntity.getUserId())
																.latitude(workHistoryDto.getLatitude())
																.longitude(workHistoryDto.getLongitude())
															.build();
		return workHistoryRepository.save(workHistoryEntity);
	}
}
