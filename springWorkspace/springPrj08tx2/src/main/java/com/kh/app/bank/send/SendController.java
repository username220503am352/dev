package com.kh.app.bank.send;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.app.bank.service.BankService;

@RequestMapping("bank")
@Controller
public class SendController {
	
	@Autowired
	private BankService bs;
	
	//이체 (화면)
	@GetMapping("send")
	public String send() {
		return "bank/send";
	}
	
	//이체 (찐)
	@PostMapping("send")
	public String send(@RequestParam HashMap<String, String> map) {
		
		int result = bs.send(map);	// UPDATE
		
		if(result == 1) {
			return "redirect:ok";
		}else {
			return "redirect:fail";
		}
		
	}

}//class
































