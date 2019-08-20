package bankware.finlab.myworkchainserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchainserver.entity.WorkPlaceEntity;

public interface WorkPlaceRepository extends CrudRepository<WorkPlaceEntity, Long> {

	List<WorkPlaceEntity> findWorkPlaceByCompAddress(String compAddress);
	String findWorkNameByWorkCode(int workCode);
}
