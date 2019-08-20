package bankware.finlab.myworkchainserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchainserver.entity.CompanyEntity;
import bankware.finlab.myworkchainserver.entity.WorkPlaceEntity;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {

	List<CompanyEntity> findAll();
}
