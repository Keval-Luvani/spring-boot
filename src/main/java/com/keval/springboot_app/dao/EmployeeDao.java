package com.keval.springboot_app.dao;

import java.sql.ResultSet;

import com.keval.springboot_app.model.Employee;

public interface EmployeeDao {
	public ResultSet getEmployees();
	public ResultSet getEmployee(int id);
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int id);
	public void addSkill(int id,String skill);
	public void deleteSkill(int id,String Skill);
	public ResultSet getSkills(int id);
}
