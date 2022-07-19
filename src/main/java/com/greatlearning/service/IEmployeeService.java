package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Employee;

import org.springframework.data.domain.Sort.Direction;

public interface IEmployeeService {
	
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee employee);

	public void deleteById(int theId);

	public List<Employee> searchBy(String name);
	
	public List<Employee> findAllCustomSorted(Direction direction);
	
}
