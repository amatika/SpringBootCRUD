package com.tiger.EmployeeManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empid;
	private String empname;
	private int age;
	public employee()
	{
		super();
		
	}
	public employee(String empname, int age) 
	{
		super();
		this.empname = empname;
		this.age = age;
	}
	public employee(int i, String string, int j) 
	{
		// TODO Auto-generated constructor stub
	}
	public int getEmpid()
	{
		return empid;
	}
	public void setEmpid(int empid) 
	{
		this.empid = empid;
	}
	public String getEmpname() 
	{
		return empname;
	}
	public void setEmpname(String empname) 
	{
		this.empname = empname;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	

}
