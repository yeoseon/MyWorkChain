package bankware.finlab.myworkchain.common.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;

public interface WorkHistoryRepository extends CrudRepository<WorkHistoryEntity, Long> {
	
	WorkHistoryEntity findWorkHistoryByUserIdAndTime(String userAddress, Timestamp time);

	List<WorkHistoryEntity> findWorkHistoryByUserId(String userId);
}
