package com.ajinkya;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ajinkya.entity.EmployeeEntity;
import com.ajinkya.repo.EmployeeRepo;
import com.ajinkya.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		EmployeeService service=context.getBean(EmployeeService.class);
		
		//save the Employee
//		service.saveEmployee();
		
//		Find record by given id
//		service.getEmployee(1);		
//		service.findAllEmpById();

//		Update Employee
//		service.updateEmployee(1, 3.0);
		
//		delete Employee 
//		service.deleteEmployee(1);
		
//		select Emp by EmpName
//		service.getEmpByName();
		
//		select Emp by EmpName and Salary
//		service.getEmpByNameAndSalary();
		
//		select Emp by EmpName or Salary
//		service.getEmpByNameOrSalary();
		
//		select * from emp where salary>= :salary;
//		service.getEmpBySalaryIsGreatherThanEqual();
		
		
//		execute hql queries
		EmployeeRepo repo=context.getBean(EmployeeRepo.class);
//		List<EmployeeEntity> employeeEntities=repo.getAllEmp();
//		for(EmployeeEntity e:employeeEntities)
//		{
//			System.out.println(e);
//		}
		
//		execute sql queries
//		List<EmployeeEntity> employeeEntities=repo.getAllEmpSql();
//		for(EmployeeEntity e:employeeEntities)
//		{
//			System.out.println(e);
//		}
//		
		
//		insert record using custom queries
//		repo.insertEmployee(4, "Chaitanya");
		
//		update the record
		repo.updateEmployee(4, 32.00);
	}
	

}
