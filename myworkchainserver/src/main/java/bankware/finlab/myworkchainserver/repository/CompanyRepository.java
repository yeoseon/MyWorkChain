package bankware.finlab.myworkchainserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchainserver.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

	List<Company> findAll();
	
}
