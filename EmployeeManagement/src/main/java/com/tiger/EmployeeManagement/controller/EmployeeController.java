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
	@GetMapping("/emp")
	@ResponseBody
	 public ModelAndView getEmp()
	   {
		  ModelAndView mv=new ModelAndView("index");
		   mv.addObject("employees",eserv.getEmp());
		   return mv;
	   }
	
	 @GetMapping("/employees")
	 public String getEmployees(Model model)
		   {
		 	   model.addAttribute("employees",eserv.getEmp());
			   return "index";
		   }
	 
	 @GetMapping("/addnew")
	    public String add(Model model) 
	    {
	        model.addAttribute("employee", new employee());
	        return "new";
	    }
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("emp") employee std)
	    {
	        eserv.addEmp(std);
	        return "redirect:/employees";
	    }
	 
	 @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id)
	    {
	        ModelAndView mav = new ModelAndView("new");
	        mav.addObject("employee", eserv.getEpmpID(id));
	        return mav;	        
	    }
	
	 @RequestMapping("/delete/{id}")
	    public ModelAndView delete(@PathVariable(name = "id") int id)
	    {
		  eserv.removeEmp(id);
		  ModelAndView mv=new ModelAndView("index");
		  mv.addObject("employee",eserv.getEmp());		   
	      return mv;	        
	    }
	 
	@RequestMapping("/add/{empname}/{age}")
		public String addEmp(@PathVariable("empname") String empname,@PathVariable("age") int age)
		{
			employee em=new employee(empname,age);
			eserv.addEmp(em);		
			return "Employee added succesfully";
		}

}
