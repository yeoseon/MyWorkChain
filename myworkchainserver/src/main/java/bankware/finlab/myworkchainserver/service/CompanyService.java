package bankware.finlab.myworkchainserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchainserver.entity.Company;
import bankware.finlab.myworkchainserver.entity.WorkPlace;
import bankware.finlab.myworkchainserver.repository.CompanyRepository;
import bankware.finlab.myworkchainserver.repository.WorkPlaceRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired 
	private WorkPlaceRepository workPlaceRepository;
	
	public List<Company> getCompanyList() {
		return companyRepository.findAll();
	}

	//TODO : 회사 정보 조회
	/*
	 * 기업 정보도 Chain이 아니라 Server 데이터로 관리해야할 것 같다.
	 * TODO: 일단 두가지 방안으로 모두 구현해둔 후에 회의 때 정해서 적용할 것.
	 */
//	public Company getCompanyInfo(String compAdrs) {
//	}
	
	/*
	 * 회사의 근무지 목록 조회
	 * Server Data 이용
	 */
	public List<WorkPlace> getWorkPlace(String compAdrs) {
		
		return workPlaceRepository.findWorkPlaceByCompAddress(compAdrs);
	}
}
