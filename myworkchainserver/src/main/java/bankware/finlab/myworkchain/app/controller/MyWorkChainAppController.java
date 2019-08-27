package bankware.finlab.myworkchain.app.controller;

import java.sql.Timestamp;
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

import com.fasterxml.jackson.core.JsonProcessingException;

import bankware.finlab.myworkchain.app.dto.WorkHistoryDto;
import bankware.finlab.myworkchain.app.service.WorkHistoryService;
import bankware.finlab.myworkchain.common.entity.WorkHistoryEntity;
import bankware.finlab.myworkchain.server.dto.NewWorkHistoryToChainRequest;
import bankware.finlab.myworkchain.server.service.WorkService;

@Controller
public class MyWorkChainAppController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyWorkChainAppController.class);
	
	@Autowired
	private WorkHistoryService workHistoryService;
	
	@Autowired
	private WorkService workService;
	
	// 하드 코딩, 추후 변경 필요 TODO
	private static final String EMPL_ADDRESS = "0xbfb07e725f66b2ac1187a5b134fbcf4a3f3beaf0";
	
	@GetMapping("/calendar")
	public String viewHome(Model model) {
		if(logger.isDebugEnabled()) logger.debug("viewHome {}", model);
		
		// Model Attributes
		List<WorkHistoryEntity> workHistoryEntityList = workHistoryService.getWorkHistoryList(EMPL_ADDRESS);
		logger.info("workHistoryEntityList : {}", workHistoryEntityList);
		model.addAttribute("workHistoryEntityList", workHistoryEntityList);
		
		// template name
		return "app/home";
	}
	
	@GetMapping("/login")
	public String viewLogin(Model model) {
		if(logger.isDebugEnabled()) logger.debug("viewLogin {}", model);
		
		// template name
		return "app/login";
	}
	
	@GetMapping("/work/history/{userId:.+}/{time}")
	public @ResponseBody WorkHistoryEntity getWorkHistory(@PathVariable("userId") String userId, @PathVariable("time") Timestamp time) {
		logger.info("userId : {}", userId);
		WorkHistoryEntity workHistoryEntity = workHistoryService.getWorkHistoryWithTime(userId, time);
		logger.info("workHistoryEntity : {}", workHistoryEntity);
		
		return workHistoryEntity;
	}
	
	@GetMapping("/work/history/{userId:.+}")
	public @ResponseBody List<WorkHistoryEntity> getWorkHistoryList(@PathVariable("userId") String userId) {
		logger.info("userAddress : {}", userId);
		List<WorkHistoryEntity> workHistoryEntityList = workHistoryService.getWorkHistoryList(userId);
		logger.info("workHistoryEntityList : {}", workHistoryEntityList);
		
		return workHistoryEntityList;
	}
	
	@Transactional
	@PostMapping("/work/history")
	public @ResponseBody Boolean newWorkHistory(@RequestBody NewWorkHistoryToChainRequest request) throws JsonProcessingException {
		logger.info("NewWorkRequest : {}", request);
		Boolean isNewWorkHistory = workService.newWorkHistory(request);
		logger.info("업무 시작 !");
		
		return isNewWorkHistory;
	}
	
	@Transactional
	@PatchMapping("/work/history")
	public @ResponseBody Boolean modifyWorkHistory(@RequestBody NewWorkHistoryToChainRequest request) throws JsonProcessingException {
		logger.info("NewWorkRequest : {}", request);
		Boolean isNewWorkHistory = workService.newWorkHistory(request);
		logger.info("업무 종료 !");
		
		return isNewWorkHistory;
	}
}