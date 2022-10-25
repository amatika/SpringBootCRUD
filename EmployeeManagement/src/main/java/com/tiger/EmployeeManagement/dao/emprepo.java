package com.tiger.EmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiger.EmployeeManagement.domain.employee;

public interface emprepo extends JpaRepository<employee, Integer>
{

}
