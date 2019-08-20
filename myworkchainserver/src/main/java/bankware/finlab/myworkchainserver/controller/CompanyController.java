package bankware.finlab.myworkchainserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bankware.finlab.myworkchainserver.service.CompanyService;

@Controller
@RequestMapping("company")
public class CompanyController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	//TODO: 데모를 위해 초기에 화면으로부터 COMPANY_ADDRESS를 입력받을 수 있도록
	private static final String COMPANY_ADDRESS = "0xcf6575a9d3bb47fc8435baacdbe7220e8e18230c";
	
	@Autowired
	CompanyService companyService; 
	
	@RequestMapping(path={"", "/"})
	public String company(Model model) {
		
		String pageName;
		pageName = "company_dashboard";

		model.addAttribute("workPlaceList", companyService.getWorkPlace(COMPANY_ADDRESS));
		return pageName;
	}
	
}
