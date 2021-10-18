package com.vamsi.sbs.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
	
	public String getData(String input) {
		return "Hello "+input+" Welcome to Spring Boot.. !!";
	}

}
