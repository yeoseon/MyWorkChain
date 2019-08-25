package bankware.finlab.myworkchain.common.repository;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;

public interface WorkHistoryRepository extends CrudRepository<WorkHistoryEntity, Long> {

}
