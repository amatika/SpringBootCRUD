package com.tiger.EmployeeManagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiger.EmployeeManagement.dao.emprepo;
import com.tiger.EmployeeManagement.domain.employee;

@Service
public class employeeservice 
{
   //injecting the employee repo interface
   @Autowired
   emprepo rp;   
   //method that returns all the employees
   public List<employee> getEmp()
   {
	  return rp.findAll();
   }   
   //method that saves a new employee
   public void addEmp(employee emp)
   {
	  rp.save(emp);
   }
   //returns the employee data based on the id that has been searched
   public employee getEpmpID(int id)
   {
	   return rp.findById(id).get();
   }
   //deletes the employee based on the given id
   public void removeEmp(int id)
   {
	   rp.deleteById(id);
	 
   }
   
}
