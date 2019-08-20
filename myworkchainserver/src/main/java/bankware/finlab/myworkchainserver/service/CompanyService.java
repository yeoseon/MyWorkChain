package bankware.finlab.myworkchainserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchainserver.entity.Company;
import bankware.finlab.myworkchainserver.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> getCompanyList() {
		return companyRepository.findAll();
	}

	//TODO : 회사 정보 조회
	//TODO : 회사 근무지 목록 조회
}
