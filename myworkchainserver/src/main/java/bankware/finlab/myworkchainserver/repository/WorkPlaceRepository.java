package bankware.finlab.myworkchainserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchainserver.entity.WorkPlace;

public interface WorkPlaceRepository extends CrudRepository<WorkPlace, Long> {

	List<WorkPlace> findWorkPlaceByCompAddress(String compAddress);
}
