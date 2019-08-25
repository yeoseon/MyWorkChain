package bankware.finlab.myworkchain.common.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;

public interface WorkHistoryRepository extends CrudRepository<WorkHistoryEntity, Long> {
	
	WorkHistoryEntity findWorkHistoryByUserAddressAndWorkStartYmd(String userAddress, String workStartYmd);

	List<WorkHistoryEntity> findWorkHistoryByUserAddress(String userAddress);
}
