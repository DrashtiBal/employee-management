package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeepayload.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employeemgt")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	
	@PostMapping("/add")
	public String addEmployee(@RequestBody EmployeeDto employeedto)
	{
		employeeService.addEmployee(employeedto);
		return "added";
		
	}
	
	@GetMapping("/get-all")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Employee> getAll(@RequestParam (value="pageNo" ,defaultValue="0")int pageNo , @RequestParam (value="pageSize",defaultValue="5")int pageSize, 
			
			@RequestParam (value="sort",defaultValue = "ename" )String sort)
									{
		 return employeeService.getAllEmployee(pageNo,pageSize,sort);
	
	}
	}
