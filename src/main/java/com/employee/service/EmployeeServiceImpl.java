package com.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.modelmapper.internal.bytebuddy.asm.Advice.OffsetMapping.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.employeepayload.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;
//import com.studentjpacrud.studentpayload.StudentDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 
	@Override
	public String addEmployee(EmployeeDto employeedto) {
		
		Employee employee = this.employeeDtoToEmployee(employeedto);
		employeeRepo.save(employee);
		return "Employee Added";
	}
	
	@Override
	public List<Employee> getAllEmployee(int pageNo,int pageSize,String sort) {
		
		//int pageSize=5;
		//int pageNo=0;
		Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by(sort).descending());
		
		 Page<Employee> emp = employeeRepo.findAll(pageable);/*.stream().map(this::employeeToEmployeeDto).collect(Collectors.toList());*/
		 return emp.getContent();
	}
	
	//MODELMAPPER METHODS
	
	public Employee employeeDtoToEmployee(EmployeeDto employeedto)
	{
		Employee employee = this.modelMapper.map(employeedto, Employee.class);
		
		return employee;
		
	}
	
	public EmployeeDto employeeToEmployeeDto(Employee employee)
	{
		    EmployeeDto employeedto= this.modelMapper.map(employee, EmployeeDto.class);
		
		return employeedto;
		
	}
}
