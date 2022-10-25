package com.tiger.EmployeeManagement.controller;

import java.net.http.HttpHeaders;

import org.springframework.web.client.RestTemplate;

public class RestClient 
{
  public static final String get_all_users="https://restcountries.com/v3.1/name/peru";
 //public static final String get_all_users="http://localhost:8080/myemployees";
  public static final String get_single_user="http://localhost:8080/myemployees/{id}";
  
  public static void getUser()
  {
	  //HttpHeaders headers=new HttpHeaders();
	  RestTemplate rst=new RestTemplate();
	  String result=rst.getForObject(get_all_users, String.class);
	  System.out.println(result);
  }
  
  
  public static void main(String args[])
  {
	  getUser();
  }
}
