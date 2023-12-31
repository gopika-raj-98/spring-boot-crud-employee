package com.gopika.springboot.crudemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopika.springboot.crudemo.Service.EmployeeService;
import com.gopika.springboot.crudemo.dao.EmployeeDAO;
import com.gopika.springboot.crudemo.entity.Employee;

@RestController
@RequestMapping("/api")

public class EmployeeRestcontroller {

	@Autowired
	private EmployeeService employeeService;
	
	// quick and dirty: inject employee dao
	@Autowired
	
	public  EmployeeRestcontroller(EmployeeService theEmployeeService) {
		
		employeeService = theEmployeeService;
		
	}
	
	// expose "/employees" and return a list of employees
	
	@GetMapping("/employees")
	
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - "  + employeeId);
		}
		
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/employees")
	
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// also just incase they pass an id in json  ..set id to 0
		
		// this is to force a save of new item..instead of update
		
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/editemployees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	
	
}
	
	
	
