package com.employee.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employeemgt")
public class Employee {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String ename;
private String email;
private String password;
private String role;
private boolean active;
}
