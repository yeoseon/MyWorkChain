package bankware.finlab.myworkchainserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bankware.finlab.myworkchainserver.entity.Billionaires;

//This is an Interface.
//No need Annotation here.
public interface MyWorkChainRepository extends CrudRepository<Billionaires, Long> {
	List<Billionaires> findAll();
}