package com.employee.employeepayload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	private int id;
	private String ename;
	private String email;
	private String password;
	private String role;
	private boolean active;
}
