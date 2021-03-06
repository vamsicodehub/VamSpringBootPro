package com.vamsi.sbapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vamsi.sbapp.bo.Employee;
import com.vamsi.sbapp.service.EmployeeService;

@RequestMapping("/rest")
@RestController
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	EmployeeService service1;
	
	@GetMapping("/helloWorld")
	public String helloWorld() {
		System.out.println("Service :: "+service);
		System.out.println("Service1 :: "+service1);
		return "Hello World";
	}
	
	@GetMapping("/saveEmp")
	public void saveEmployee() {
		System.out.println("Service :: "+service);
		System.out.println("Service1 :: "+service1);
		service.saveEmployee();
	}
	
	@PostMapping("/updateEmp/{id}")
	public Employee updateEmployee(@RequestParam String name, @PathVariable Long id) {
		System.out.println("Service :: "+service);
		System.out.println("Service1 :: "+service1);
		return service.updateEmployee(id);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public void deleteEmployee(@RequestParam Long id) {
		service.deleteEmployee(id);
	}

}
