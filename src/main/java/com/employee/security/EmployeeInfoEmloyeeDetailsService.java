package com.employee.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepo;

@Component
public class EmployeeInfoEmloyeeDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<Employee> employee =employeeRepo.findEmployeeByEname(username);
	System.out.println(employee.get().getEmail());
	System.out.println(employee.get().getPassword());
	return employee.map(EmployeeInfoEmployeeService::new).orElseThrow(()->new UsernameNotFoundException("User Name Not Found"));
		
	}

}
