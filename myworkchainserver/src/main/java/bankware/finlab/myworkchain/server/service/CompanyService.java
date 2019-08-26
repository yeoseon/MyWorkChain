package bankware.finlab.myworkchain.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchain.common.entity.CompanyEntity;
import bankware.finlab.myworkchain.common.entity.WorkPlaceEntity;
import bankware.finlab.myworkchain.common.repository.CompanyRepository;
import bankware.finlab.myworkchain.common.repository.WorkPlaceRepository;
import bankware.finlab.myworkchain.server.vo.Company;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired 
	private WorkPlaceRepository workPlaceRepository;
	
	public List<CompanyEntity> getCompanyList() {
		return companyRepository.findAll();
	}

	//TODO : 회사 정보 조회
	/*
	 * 기업 정보도 Chain이 아니라 Server 데이터로 관리해야할 것 같다.
	 * TODO: 일단 두가지 방안으로 모두 구현해둔 후에 회의 때 정해서 적용할 것.
	 */
	public Company getCompanyInfo(String compAdrs) {
		
		Company company = new Company();
		
		return company;
	}
	
	/*
	 * 회사의 근무지 목록 조회
	 * Server Data 이용
	 * TODO: 근무지 목록을 효과적으로 보여줄 수 있는 방법 생각
	 * TODO: HTML Geo 라이브러리 이용하여 의미있는 데이터 넣어두기
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
