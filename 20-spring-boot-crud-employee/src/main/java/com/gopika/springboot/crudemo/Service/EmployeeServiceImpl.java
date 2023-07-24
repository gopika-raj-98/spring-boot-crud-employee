package com.gopika.springboot.crudemo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gopika.springboot.crudemo.dao.EmployeeDAO;
import com.gopika.springboot.crudemo.entity.Employee;

import jakarta.transaction.Transactional;

@ Service

public class EmployeeServiceImpl implements EmployeeService {

private EmployeeDAO employeeDAO;

public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
	employeeDAO =theEmployeeDAO;
}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		return employeeDAO.findById( theId);
	}

	@Override	
	public Employee findByName(String name) {
	
	return employeeDAO.findByName(name);
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
	
		return employeeDAO.save(theEmployee);
	}

	

	
	

	

	
	
}
