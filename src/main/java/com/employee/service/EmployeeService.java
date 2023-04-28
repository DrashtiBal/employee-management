package com.employee.service;

import java.util.List;

import com.employee.employeepayload.EmployeeDto;
import com.employee.entity.Employee;

public interface EmployeeService {
public String addEmployee(EmployeeDto employeedto);
public List<Employee> getAllEmployee(int pageNo,int pageSize,String sort);
}
