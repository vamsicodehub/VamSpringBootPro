package com.vamsi.sbapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vamsi.sbapp.bo.Address;
import com.vamsi.sbapp.bo.Employee;
import com.vamsi.sbapp.dao.EmployeeRepository;
import com.vamsi.sbapp.dao.EmployeeTestDao;

@Transactional
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.DEFAULT)
public class EmployeeService {

	EmployeeRepository employeeRepsoitory = getEmployeeRepository();
	
	EmployeeRepository employeeRepsoitory1 = getEmployeeRepository();
	
	@Autowired
	EmployeeTestDao employeeTestDao;
	
	@Autowired
	EmployeeTestDao employeeTestDao1;

	public Employee saveEmployee() {
		System.out.println("EmployeeRepsoitory :: "+employeeRepsoitory);
		System.out.println("EmployeeRepsoitory1 :: "+employeeRepsoitory1);
		
		System.out.println("EmployeeTestDao :: "+employeeTestDao);
		System.out.println("EmployeeTestDao1 :: "+employeeTestDao1);
		
		Employee employee = createEmployee();
		employeeRepsoitory.save(employee);
		
		return employee;

	}
	
	@Lookup
	public EmployeeRepository getEmployeeRepository() {
		return null;
	}
	
	public Employee updateEmployee(Long id) {
		System.out.println("EmployeeRepsoitory :: "+employeeRepsoitory);
		Optional<Employee> employeeOpt = employeeRepsoitory.findById(id);
		Employee employee = employeeOpt.get();
		
		Address address = new Address();
		address.setCity("Bangalore");
		address.setPincode(600001);
		address.setEmployee(employee);
		
		employee.getAddresses().clear();
		
		employee.getAddresses().add(address);
		
		employeeRepsoitory.save(employee);
		
		return employee;

	}

	private Employee createEmployee() {
		Employee employee = new Employee();
		employee.setName("Vamsi");
		employee.setDesignation("PE");
		employee.setEmpCode("3103");

		Address address = new Address();
		address.setCity("Nuzvid");
		address.setPincode(521201);
		address.setEmployee(employee);

		employee.getAddresses().add(address);

		address = new Address();
		address.setCity("Airoli");
		address.setPincode(400708);
		address.setEmployee(employee);

		employee.getAddresses().add(address);

		return employee;
	}

	public void deleteEmployee(Long id) {
		employeeRepsoitory.delete(employeeRepsoitory.findById(id).get());
	}

}
