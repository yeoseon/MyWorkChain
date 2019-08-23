package bankware.finlab.myworkchainserver.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchainserver.service.CompanyService;
import bankware.finlab.myworkchainserver.service.EmployeeService;
import bankware.finlab.myworkchainserver.vo.Employee;

@Controller
public class CompanyController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	//TODO: 데모를 위해 초기에 화면으로부터 COMPANY_ADDRESS를 입력받을 수 있도록
	private static final String COMPANY_ADDRESS = "0x69f2d1bdc2430a3a067620f617fec3100b892d54";
	
	@Autowired
	CompanyService companyService; 
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(path={"", "/", "company", "/company"})
	public String company(Model model) throws RestClientException, JsonProcessingException {
		
		String pageName;
		pageName = "company_dashboard";

		List<Employee> employeeList = employeeService.getEmployeeList(COMPANY_ADDRESS);
		
		model.addAttribute("workPlaceList", companyService.getWorkPlace(COMPANY_ADDRESS));
		model.addAttribute("employeeList", employeeList);
		return pageName;
	}
	
}
