package net.osmanforhad.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.osmanforhad.springbootrestapi.exception.ResourceNotFoundException;
import net.osmanforhad.springbootrestapi.model.Employee;
import net.osmanforhad.springbootrestapi.repository.EmployeeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	// inject EmployeeRepository class as dependency
	@Autowired
	private EmployeeRepository employeeRepository;

	// get all employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	// create new employee
	@PostMapping("create_employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	// get employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee not exists with id : " + id));
		return ResponseEntity.ok(employee);

	}

	// update employee
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updateEmpinfo) {
		// fetch and match the employee data with DB
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employe not exists with id : " + id));

		// set employee info to update into DB
		employee.setFirstName(updateEmpinfo.getFirstName());
		employee.setLastName(updateEmpinfo.getLastName());
		employee.setEmailId(updateEmpinfo.getEmailId());

		// update the employee info
		Employee updatedEmployee = employeeRepository.save(employee);

		return ResponseEntity.ok(updatedEmployee);
	}

	// delete employee
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
		// check the given employee id is exists or not
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("employee not exists with id : " + id));
		employeeRepository.delete(employee);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
