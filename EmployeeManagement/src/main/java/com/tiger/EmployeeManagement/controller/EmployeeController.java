package com.tiger.EmployeeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.tiger.EmployeeManagement.domain.employee;
import com.tiger.EmployeeManagement.services.employeeservice;

@Controller
public class EmployeeController 
{
	 @Autowired
	 employeeservice eserv;
	 //this request mapping fetches all the employees from the database
	 @GetMapping("/employees")
	  public String getEmployees(Model model)
		 {
		 	 model.addAttribute("employees",eserv.getEmp());
			 return "index";
		 }	 
	  //this request returns the page used to add new employees
	 @GetMapping("/addnew")
	    public String add(Model model) 
	    {
	        model.addAttribute("employee", new employee());
	        return "new";
	    }		 
	   //this request would save the employee details into the database and redirect to the home page
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveEmployee(@ModelAttribute("emp") employee std)
	    {
	        eserv.addEmp(std);
	        return "redirect:/employees";
	    }
	  //this request would edit the employee details based on their employee id 
	  @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id)
	    {
	        ModelAndView mav = new ModelAndView("new");
	        mav.addObject("employee", eserv.getEpmpID(id));
	        return mav;	        
	    }	
	  //this request would delete the employee details based on their employee id 
	  @RequestMapping("/delete/{id}")
	    public String delete(@PathVariable(name = "id") int id,Model model)
	    {
		  eserv.removeEmp(id);
		  model.addAttribute("employees",eserv.getEmp());
		  return "index";	   
	            
	    }
	 
	

}
