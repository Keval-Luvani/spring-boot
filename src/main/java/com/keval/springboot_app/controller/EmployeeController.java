package com.keval.springboot_app.controller;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.keval.springboot_app.model.Employee;
import com.keval.springboot_app.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeServiceImpl; 
	
	
	@RequestMapping("/view")
	public String viewEmployee(Model model) {
		model.addAttribute("employeeList",employeeServiceImpl.viewEmployee());
		return "ViewEmployee.jsp";
	}
	
	@RequestMapping("/create")
	public String createPage(Model model) {
		model.addAttribute("todayDate", LocalDate.now().toString());
		model.addAttribute("employee",new Employee());
		return "EmployeeDataEntry.jsp";
	}
	
	@RequestMapping("/update{employeeId}")
	public String updatePage(Model model,@PathVariable int employeeId) {
		model.addAttribute("todayDate", LocalDate.now().toString());
		model.addAttribute("employee",employeeServiceImpl.fetchData(employeeId));
		return "EmployeeDataEntry.jsp";
	}
	
	@RequestMapping("/delete{employeeId}")
	public String Employee(@PathVariable int employeeId) {
		employeeServiceImpl.deleteEmployee(employeeId);
		return "redirect:view";
	}
	
	@RequestMapping(value="/submit", method= RequestMethod.POST)
	public String createEmployee(@ModelAttribute("employee") Employee employee) {
		if(employee.getEmployeeId()==0) {
			employeeServiceImpl.createEmployee(employee);
		}else {
			employeeServiceImpl.updateEmployee(employee);
		}
		return "redirect:view";
	}
}