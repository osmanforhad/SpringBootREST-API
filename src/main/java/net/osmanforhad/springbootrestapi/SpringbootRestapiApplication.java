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
		
		//create Model Entity object
//		Employee employee = new Employee();
		//set data to save as dummy data
//		employee.setFirstName("Mr");
//		employee.setLastName("osman");
//		employee.setEmailId("osman@gmail.com");
		
		//save dummy data into DB through the Repository Interface
//		employeeRepository.save(employee);
		
	}

}
