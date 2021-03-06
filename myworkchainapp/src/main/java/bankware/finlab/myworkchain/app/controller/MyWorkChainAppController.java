package bankware.finlab.myworkchain.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import bankware.finlab.myworkchain.app.dto.WorkHistoryDto;
import bankware.finlab.myworkchain.app.service.WorkHistoryService;
import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;

@Controller
public class MyWorkChainAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWorkChainAppController.class);
	
	@Autowired
	private WorkHistoryService workHistoryService;
	
	// 하드 코딩, 추후 변경 필요 TODO
	private static final String EMPL_ADDRESS = "0xB31794ef274FFb1e6e4a55bAE4f9F18DeBA3C112";
	
	@GetMapping("/")
	public String viewHome(Model model) {
		if(logger.isDebugEnabled()) logger.debug("viewHome {}", model);
		
		// Model Attributes
		List<WorkHistoryEntity> workHistoryEntityList = workHistoryService.getWorkHistoryList(EMPL_ADDRESS);
		logger.info("workHistoryEntityList : {}", workHistoryEntityList);
		model.addAttribute("workHistoryEntityList", workHistoryEntityList);
		
		// template name
		return "home";
	}
	
	@GetMapping("/login")
	public String viewLogin(Model model) {
		if(logger.isDebugEnabled()) logger.debug("viewLogin {}", model);
		
		// template name
		return "login";
	}
	
	@GetMapping("/work/history/{userAddress:.+}/{workStartYmd}")
	public @ResponseBody WorkHistoryEntity getWorkHistory(@PathVariable("userAddress") String userAddress, @PathVariable("workStartYmd") String workStartYmd) {
		logger.info("userAddress : {}", userAddress);
		WorkHistoryEntity workHistoryEntity = workHistoryService.getWorkHistoryWithWorkStartYmd(userAddress, workStartYmd);
		logger.info("workHistoryEntity : {}", workHistoryEntity);
		
		return workHistoryEntity;
	}
	
	@GetMapping("/work/history/{userAddress:.+}")
	public @ResponseBody List<WorkHistoryEntity> getWorkHistoryList(@PathVariable("userAddress") String userAddress) {
		logger.info("userAddress : {}", userAddress);
		List<WorkHistoryEntity> workHistoryEntityList = workHistoryService.getWorkHistoryList(userAddress);
		logger.info("workHistoryEntityList : {}", workHistoryEntityList);
		
		return workHistoryEntityList;
	}
	
	@Transactional
	@PostMapping("/work/history")
	public @ResponseBody WorkHistoryEntity newWorkHistory(@RequestBody WorkHistoryDto workHistoryDto) {
		logger.info("workHistoryDto : {}", workHistoryDto);
		WorkHistoryEntity workHistoryEntity = workHistoryService.newWorkHistory(workHistoryDto);
		logger.info("{} - 업무 시작 !", workHistoryDto.getUserAddress());
		
		return workHistoryEntity;
	}
	
	@Transactional
	@PatchMapping("/work/history")
	public @ResponseBody WorkHistoryEntity modifyWorkHistory(@RequestBody WorkHistoryDto workHistoryDto) {
		logger.info("modifyWorkHistory : {}", workHistoryDto);
		WorkHistoryEntity workHistoryEntity = workHistoryService.modifyWorkHistory(workHistoryDto);
		logger.info("{} - 업무 종료 !", workHistoryDto.getUserAddress());
		
		return workHistoryEntity;
	}
}