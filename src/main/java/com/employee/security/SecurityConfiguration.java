package com.employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.employee.entity.Employee;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration    {

	
	//Authentication
	@Bean
	public UserDetailsService userDetailsService()
	{
//		UserDetails admin=User.withUsername("admin")
//				.password(encoder.encode("admin#123"))
//				.roles("admin")
//				.build();
//		return new InMemoryUserDetailsManager(admin);
		return new EmployeeInfoEmloyeeDetailsService(); 
	}
	
	
	//Authentication
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{
		return  http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/employeemgt/welcome","/employeemgt/add").permitAll()
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/employeemgt/**").authenticated()
		.and().httpBasic().and().build();
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return daoAuthenticationProvider;
	}
}
