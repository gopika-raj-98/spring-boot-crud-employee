package com.gopika.springboot.crudemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gopika.springboot.crudemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository

public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define field for entity manager
	
	private EntityManager entityManager;
	
	
	
	// set up constructor injection
	
	@Autowired
	
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		
		entityManager = theEntityManager;
		
	}
	
	@Override
	public List<Employee> findAll() {
		
		// craete a query 
		
		
		TypedQuery<Employee> theQuery = entityManager.createQuery( "from Employee", Employee.class);
		
		// execute query and get result list
		
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		
		return employees;
		
		
		
	
	}

	@Override
	public Employee findById(int theId) {
	
		// get employee
		
		Employee theEmployee =entityManager.find(Employee.class , theId);
		
		// return employee
		
		return theEmployee;
		
	}	
		
	

	@Override
	public Employee save(Employee theEmployee) {
		
		// save the dbEmployee
		
		Employee dbEmployee = entityManager.merge(theEmployee );
		
		// return employee
		
		
		return theEmployee;
	}

	

	@Override
	public Employee findByName(String firstName) {
		
		Employee theEmployee = entityManager.find(Employee.class, firstName);
		return theEmployee;
	}

	

}
