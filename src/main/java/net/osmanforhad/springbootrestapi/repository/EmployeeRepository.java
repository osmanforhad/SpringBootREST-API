package net.osmanforhad.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.osmanforhad.springbootrestapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
