package net.osmanforhad.springbootrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.osmanforhad.springbootrestapi.model.Employee;
import net.osmanforhad.springbootrestapi.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootRestapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestapiApplication.class, args);
	}

	//inject EmployeeRepository class as dependency
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
