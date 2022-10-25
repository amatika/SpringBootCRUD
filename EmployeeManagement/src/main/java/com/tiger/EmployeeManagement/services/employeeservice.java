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
   @Autowired
   emprepo rp;   
   //method that returns all the employees
   public List<employee> getEmp()
   {
	   /*List<employee> emp=new ArrayList();
	   emp.add(new employee("Ken",22));
	   emp.add(new employee("Alex",21));
	   emp.add(new employee("John",30));*/
	   return rp.findAll();
   }
   
   //method that saves a new employee
   public void addEmp(employee emp)
   {
	  rp.save(emp);
   }
   
   public employee getEpmpID(int id)
   {
	   return rp.findById(id).get();
   }
    
   public void removeEmp(int id)
   {
	   rp.deleteById(id);
	 
   }
   
}
