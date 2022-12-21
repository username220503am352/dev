package com.kh.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("test")
	public String test() {
		
		logger.trace("트레이스~~~");
		logger.debug("디버그~~~");
		logger.info("인포 ~~~");
		logger.warn("경고 ~~~");
		logger.error("에러~~~");
		
		return "test method called...";
	}

}//class




















