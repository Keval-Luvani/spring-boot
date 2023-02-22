package com.keval.springboot_app.service;

import java.util.List;

import com.keval.springboot_app.model.Employee;

public interface EmployeeService {

	Employee fetchData(int employeeId);

	void deleteEmployee(int employeeId);

	List<Employee> viewEmployee();
	
	void createEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
}
