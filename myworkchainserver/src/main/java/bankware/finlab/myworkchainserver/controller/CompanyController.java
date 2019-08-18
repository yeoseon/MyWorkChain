package bankware.finlab.myworkchainserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("company")
public class CompanyController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@RequestMapping(path={"", "/"})
	public String company() {
		
		String pageName;
		
		pageName = "company_dashboard";
		
		return pageName;
	}
	
}
