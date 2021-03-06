package com.vamsi.sbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamsi.sbs.model.ErrorResponse;
import com.vamsi.sbs.service.HelloService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "rest", tags = "Controller for Hello related API's")
@RestController
@RequestMapping("/rest")
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	@ApiOperation(value = "Get Hello by sending Name" , response = String.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200 , message = "Success" , response = String.class),
		@ApiResponse(code = 401 , message = "Unauthorized" , response = ErrorResponse.class),
		@ApiResponse(code = 403 , message = "Forbidden" , response = ErrorResponse.class),
		@ApiResponse(code = 404 , message = "Not Found")
	})
	@GetMapping("/hello")
	public String hello(@ApiParam(defaultValue = "Vamsi-Swag") @RequestParam("bar") String bar)
	{
		return helloService.provideService(bar);
	}

	@GetMapping(value = "/helloWorld", produces = {MediaType.ALL_VALUE}, consumes = {MediaType.ALL_VALUE})
	public String helloWorld() {
		return "Hello World";
	}
	
}
