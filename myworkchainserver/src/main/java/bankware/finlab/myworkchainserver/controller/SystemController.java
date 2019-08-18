package bankware.finlab.myworkchainserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system")
public class SystemController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@RequestMapping(path={"", "/"})
	public String company() {
		
		String pageName;
		
		pageName = "system_customer";
		
		return pageName;
	}
	
	@RequestMapping(path={"reward", "/reward"})
	public String reward() {
		
		String pageName;
		
		pageName = "system_reward";
		
		return pageName;
	}
}
