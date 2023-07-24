package com.gopika.springboot.crudemo.dao;

import java.util.List;

import com.gopika.springboot.crudemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee>findAll() ;
	 
	 
	 Employee findById(int theId);
	 
	 Employee save(Employee theEmployee);
	 
	 Employee findByName(String name);
	 
	 
	 
	}


