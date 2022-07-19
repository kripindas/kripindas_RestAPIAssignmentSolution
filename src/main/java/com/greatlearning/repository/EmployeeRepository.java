package com.greatlearning.repository;

import java.util.List;

import com.greatlearning.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);
	
}
