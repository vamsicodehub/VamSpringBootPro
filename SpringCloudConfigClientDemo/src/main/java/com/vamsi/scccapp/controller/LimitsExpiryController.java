package com.vamsi.scccapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamsi.scccapp.config.Limits;
import com.vamsi.scccapp.config.LimitsExpiry;

@RequestMapping("/rest")
@RestController
public class LimitsExpiryController {
	
	@Autowired
	LimitsExpiry limitsExpiry;
	
	@GetMapping("/limits")
	public Limits getLimiExpiry() {
		return new Limits(limitsExpiry.getMinimum(), limitsExpiry.getMaximum());
		
	}

}
