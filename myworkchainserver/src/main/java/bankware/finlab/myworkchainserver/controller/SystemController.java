package bankware.finlab.myworkchainserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bankware.finlab.myworkchainserver.service.SystemService;

@Controller
@RequestMapping("system")
public class SystemController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(path={"", "/"})
	public String company(Model model) {
		
		String pageName;
		pageName = "system_customer";
		
		model.addAttribute("companyList", systemService.getCompanyList());
		
		return pageName;
	}
	
	@RequestMapping(path={"reward", "/reward"})
	public String reward() {
		
		String pageName;
		
		pageName = "system_reward";
		
		return pageName;
	}
}
