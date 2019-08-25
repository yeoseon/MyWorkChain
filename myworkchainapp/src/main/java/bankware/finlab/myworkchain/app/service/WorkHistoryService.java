package bankware.finlab.myworkchain.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchain.app.dto.WorkHistoryDto;
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
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDate = localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String localTime = localDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HHmmss"));
		
		WorkHistoryEntity workHistoryEntity = WorkHistoryEntity.builder()
																	.userAddress(workHistoryDto.getUserAddress())
																	.workStartYmd(localDate)
																	.workStartTime(localTime)
																	.build();
		return workHistoryRepository.save(workHistoryEntity);
	}

	/**
	 * Work History 가져오기
	 * @param userAddress
	 * @param workStartYmd
	 * @return
	 */
	public WorkHistoryEntity getWorkHistoryWithWorkStartYmd(String userAddress, String workStartYmd) {
//		LocalDateTime localDateTime = LocalDateTime.now();
//		String localDate = localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		return workHistoryRepository.findWorkHistoryByUserAddressAndWorkStartYmd(userAddress, workStartYmd);
	}
	
	/**
	 * Work History 목록 가져오기
	 * @param userAddress
	 * @return
	 */
	public List<WorkHistoryEntity> getWorkHistoryList(String userAddress) {
		return workHistoryRepository.findWorkHistoryByUserAddress(userAddress);
	}
	
	/**
	 * Work History 수정
	 * @param workHistoryDto
	 * @return WorkHistoryEntity
	 */
	public WorkHistoryEntity modifyWorkHistory(WorkHistoryDto workHistoryDto) {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDate = localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String localTime = localDateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HHmmss"));
		
		WorkHistoryEntity oldWorkHistoryEntity = getWorkHistoryWithWorkStartYmd(workHistoryDto.getUserAddress(), localDate);
		WorkHistoryEntity workHistoryEntity = WorkHistoryEntity.builder()
																.id(oldWorkHistoryEntity.getId())
																.userAddress(oldWorkHistoryEntity.getUserAddress())
																.workStartYmd(oldWorkHistoryEntity.getWorkStartYmd())
																.workStartTime(oldWorkHistoryEntity.getWorkStartTime())
																.workEndYmd(localDate)
																.workEndTime(localTime)
															.build();
		return workHistoryRepository.save(workHistoryEntity);
	}
}
