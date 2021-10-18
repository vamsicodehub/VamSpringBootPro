package com.vamsi.sbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vamsi.sbs.dao.HelloRepository;

@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class HelloService implements HelloServiceI{
	
	@Autowired
	HelloRepository helloRepository;

	@Override
	public String provideService(String input) {
		return helloRepository.getData(input);
	}

}
