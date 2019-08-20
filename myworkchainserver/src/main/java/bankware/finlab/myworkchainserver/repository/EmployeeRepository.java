package bankware.finlab.myworkchainserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchainserver.entity.EmployeeEntity;
import bankware.finlab.myworkchainserver.vo.Employee;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

	List<EmployeeEntity> findAll();
	List<EmployeeEntity> findEmployeeByEmplAddress(String emplAddress);
}
