package bankware.finlab.myworkchainapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bankware.finlab.myworkchainapp.service.MyWorkChainService;

@Controller
public class MyWorkChainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWorkChainController.class);
	
	@Autowired
	private MyWorkChainService myWorkChainService;
	
	@GetMapping("/")
	public String viewHome(Model model) {
		if(logger.isDebugEnabled()) logger.debug("viewHome {}", model);
		
		model.addAttribute("billionailesList", myWorkChainService.getBillionailes());
		
		// template name
		return "home";
	}
}