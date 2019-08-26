package bankware.finlab.myworkchain.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchain.common.entity.CompanyEntity;
import bankware.finlab.myworkchain.common.entity.WorkPlaceEntity;
import bankware.finlab.myworkchain.common.repository.CompanyRepository;
import bankware.finlab.myworkchain.common.repository.WorkPlaceRepository;
import bankware.finlab.myworkchain.server.vo.Company;
import bankware.finlab.myworkchain.server.vo.Employee;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired 
	private WorkPlaceRepository workPlaceRepository;
	
	/*
	 * 전체 회사 목록 조회
	 */
	public List<CompanyEntity> getCompanyList() {
		return companyRepository.findAll();
	}

	/*
	 * 회사의 정보 조회
	 */
	public Company getCompanyInfo(String compAdrs) {
		
		CompanyEntity companyEntity = companyRepository.findCompanyByCompAddress(compAdrs);
		
		Company company = Company.builder()
						.compAddress(companyEntity.getCompAddress())
						.name(companyEntity.getCompName())
						.address(companyEntity.getLocation())
						.useYn(companyEntity.getUseYn())
						.build();
		
		return company;
	}
	
	/*
	 * 회사의 근무지 목록 조회
	 */
	public List<WorkPlaceEntity> getWorkPlace(String compAdrs) {
		
		return workPlaceRepository.findWorkPlaceByCompAddress(compAdrs);
	}
	
	/*
	 * WorkPlace Code를 입력받아, 근무지 이름 조회
	 */
	public String getWorkPlaceName(int workPlaceCode) {
		
		WorkPlaceEntity workPlace = workPlaceRepository.findWorkNameByWorkCode(workPlaceCode);
		return workPlace.getWorkName();
	}
	
}
