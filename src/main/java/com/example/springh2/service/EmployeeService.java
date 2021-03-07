package com.example.springh2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springh2.model.Employee;
import com.example.springh2.repository.EmployeeRepository;


@Service
public class EmployeeService {

	
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
	return 	employeeRepository.findAll();
	}

	public String addEmployee(Employee emp) {
		String response ;
		if (employeeRepository.addEmployee(emp))response = "Success";
		else response = "Faild";
		return response;
	}

	public String editEmployee(Employee emp) {
		String response ;
		if (employeeRepository.editEmployee(emp))response ="Edit Success";
		else response = "Edit Faild !";
		return response ;
				
	}

	public String deleteEmployee(int  id) {
		String response;
		if(employeeRepository.deleteEmployee(id))response = "ِDelete Success";
		else response = "Delete False";
		return response;
	}
	

	
}
