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
	
	@Autowired
	CompanyService companyService; 
	
	@RequestMapping(path={"", "/"})
	public String company(Model model) {
		
		String pageName;
		pageName = "company_dashboard";

		model.addAttribute("companyList", companyService.getCompanyList());
		return pageName;
	}
	
}
