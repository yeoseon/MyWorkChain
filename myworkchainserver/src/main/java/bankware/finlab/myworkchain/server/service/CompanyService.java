package bankware.finlab.myworkchain.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchain.common.entity.CompanyEntity;
import bankware.finlab.myworkchain.common.entity.WorkPlaceEntity;
import bankware.finlab.myworkchain.common.repository.CompanyRepository;
import bankware.finlab.myworkchain.common.repository.WorkPlaceRepository;
import bankware.finlab.myworkchain.server.vo.WorkPlace;

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
	public CompanyEntity getCompanyInfo(String compAdrs) {
		
		CompanyEntity company = companyRepository.findCompanyByCompAddress(compAdrs);
		
		return company;
	}
	
	/*
	 * 회사의 근무지 목록 조회
	 */
	public List<WorkPlaceEntity> getWorkPlace(String compAdrs) {
		
		return workPlaceRepository.findWorkPlaceByCompAddress(compAdrs);
	}
	
	/*
	 * WorkPlace Code를 입력받아, 근무지 객체 조회
	 */
	public WorkPlace getWorkPlaceByCode(String workPlaceCode) {
		
		WorkPlaceEntity workPlaceEntity = workPlaceRepository.findWorkNameByWorkCode(workPlaceCode);
		
		WorkPlace workplace = WorkPlace.builder()
	 			.workCode(workPlaceEntity.getWorkCode())
				.compAddress(workPlaceEntity.getCompAddress())
				.workName(workPlaceEntity.getWorkName())
				.workAddress(workPlaceEntity.getWorkAddress())
				.longitude(workPlaceEntity.getWorkGeoLongitude())
				.latitude(workPlaceEntity.getWorkGeoLatitude())
				.workUseYn(workPlaceEntity.getWorkUseYn())
				.build();
		
		return workplace;
	}
	
	/*
	 * WorkPlace Code를 입력받아, 근무지 이름 조회
	 */
	public String getWorkPlaceName(String workPlaceCode) {
		
		WorkPlaceEntity workPlace = workPlaceRepository.findWorkNameByWorkCode(workPlaceCode);
		return workPlace.getWorkName();
	}
	
}
