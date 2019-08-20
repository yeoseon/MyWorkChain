package bankware.finlab.myworkchainserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchainserver.entity.CompanyEntity;
import bankware.finlab.myworkchainserver.repository.CompanyRepository;

@Service
public class SystemService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<CompanyEntity> getCompanyList() {
		return companyRepository.findAll();
	}
}
