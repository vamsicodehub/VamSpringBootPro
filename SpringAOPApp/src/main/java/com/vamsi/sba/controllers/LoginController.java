package com.vamsi.sba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamsi.sba.service.LoginService;

@RestController
@RequestMapping("/vamsi/rest")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/authenticate")
	public boolean authenticateUser(String username, String password) {
		return loginService.authenticateUser();
	}                          
	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}

}
