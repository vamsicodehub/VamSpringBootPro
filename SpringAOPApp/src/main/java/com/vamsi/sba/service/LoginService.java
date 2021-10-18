package com.vamsi.sba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamsi.sba.dao.LoginDAO;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	public boolean authenticateUser() {
		return loginDAO.authenticateUser();
	}

}
