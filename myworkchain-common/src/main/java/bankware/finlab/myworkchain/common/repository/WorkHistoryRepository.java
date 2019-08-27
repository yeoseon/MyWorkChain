package bankware.finlab.myworkchain.common.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;

public interface WorkHistoryRepository extends CrudRepository<WorkHistoryEntity, Long> {
	
	WorkHistoryEntity findWorkHistoryByUserIdAndTime(String userAddress, LocalDateTime time);

	List<WorkHistoryEntity> findWorkHistoryByUserId(String userId);
}
