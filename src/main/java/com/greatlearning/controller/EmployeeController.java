package com.greatlearning.controller;

import java.util.List;

import com.greatlearning.entity.Employee;
import com.greatlearning.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@PostMapping("")
	public String home() {
		return "Welcome to Employee Management Portal";
	}

	@GetMapping("/list")
	public List<Employee> getEmployeesList() {
		return employeeService.findAll();
	}

	@PostMapping("/add")
	public Employee addEmployee(Employee employee) {
		employeeService.save(employee);
		return employeeService.findById(employee.getId());
	}

	@DeleteMapping("/delete")
	public String deleteEmployee(int id) {
		employeeService.deleteById(id);
		return "Deleted employee with id: " + id;
	}

	@GetMapping("/get")
	public Employee getEmployee(int id) {
		return employeeService.findById(id);
	}

	@PostMapping("/update")
	public Employee updateEmployee(Employee employee) {
		employeeService.save(employee);
		return employeeService.findById(employee.getId());
	}

	@GetMapping("/search")
	public List<Employee> searchEmployees(String firstName){
		return employeeService.searchBy(firstName);
	}
	
	@GetMapping("/sortlist")
	public List<Employee> sortEmployee(Direction direction){
		return employeeService.findAllCustomSorted(direction);
	}
	
}
