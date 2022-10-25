package com.tiger.EmployeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.EmployeeManagement.domain.employee;
import com.tiger.EmployeeManagement.services.employeeservice;

@RestController
public class EmployeeRestController 
{
	@Autowired
	employeeservice service;

	@RequestMapping("/myemployees")
	public List<employee> getEmployees()
	{		
		return service.getEmp();
	}
	
	@GetMapping("/myemployees/{id}")
	public employee getEmployee(@PathVariable("id") int id)
	{		
		return service.getEpmpID(id);
	}
}
