package com.example.springh2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springh2.model.Employee;
import com.example.springh2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@GetMapping("/")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@PostMapping("/")
	
	public String addEmployee (@RequestBody Employee emp) {
		
		return employeeService.addEmployee(emp);
	}
	@PutMapping("/")
	
	public String editEmployee (@RequestBody Employee emp) {
		
		return employeeService.editEmployee(emp);
	}
    @DeleteMapping("/{id}")
	
	public String DeleteEmployee (@PathVariable("id") int id) {
		
		return employeeService.deleteEmployee(id);
	}
}
