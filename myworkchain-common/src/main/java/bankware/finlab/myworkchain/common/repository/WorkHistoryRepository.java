package bankware.finlab.myworkchain.common.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;

public interface WorkHistoryRepository extends CrudRepository<WorkHistoryEntity, Long> {
	
	List<WorkHistoryEntity> findWorkHistoryByUserIdAndTimeBetween(String userId, LocalDate now, LocalDate after);

	List<WorkHistoryEntity> findWorkHistoryByUserId(String userId);
}
