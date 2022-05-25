package net.osmanforhad.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.osmanforhad.springbootrestapi.model.Employee;
import net.osmanforhad.springbootrestapi.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	//inject EmployeeRepository class as dependency
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
