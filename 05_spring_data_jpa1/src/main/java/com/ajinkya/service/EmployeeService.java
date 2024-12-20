package com.ajinkya.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ajinkya.entity.EmployeeEntity;
import com.ajinkya.repo.EmployeeRepo;

@Service
public class EmployeeService {
	EmployeeRepo repo;
	public EmployeeService(EmployeeRepo repo)
	{
		this.repo=repo;
		System.out.println(this.repo.getClass().getName());
	}
	
	public void saveEmployee() {
		EmployeeEntity employee=new EmployeeEntity();
		employee.setEmpId(1);
		employee.setEmpName("Ajinkya");
		employee.setSalary(432.2);
		
		this.repo.save(employee);
	}
	public void getEmployee(Integer id) {
		Optional<EmployeeEntity> data=repo.findById(id);
		if(data.isPresent())
		{
			EmployeeEntity e=data.get();
			System.out.println(e);
		}
	}
	public void findAllEmpById() {
		List<Integer> list=Arrays.asList(1,2);
		Iterable<EmployeeEntity> iterable=repo.findAllById(list);
		for(EmployeeEntity e:iterable)
		{
			System.out.println(e);
		}
	}
	public void updateEmployee(Integer id, Double salary) {
	    Optional<EmployeeEntity> data = repo.findById(id);
	    if (data.isPresent()) {
	        EmployeeEntity employeeEntity = data.get();
	        employeeEntity.setSalary(salary);
	        repo.save(employeeEntity);
	    } else {
	        System.out.println("Employee with ID " + id + " not found.");
	    }
	}
	public void deleteEmployee(Integer id)
	{
		repo.deleteById(id);
	}
	
	public void getEmpByName()
	{
		List<EmployeeEntity> employeeEntities=repo.findByEmpName("Ajinkya");
		
		for(EmployeeEntity e:employeeEntities)
		{
			System.out.println(e);
		}
	}
	
	public void getEmpByNameAndSalary()
	{
		List<EmployeeEntity> employeeEntities=repo.findByEmpNameAndSalary("Ajinkya", 23.00);
		
		for(EmployeeEntity e:employeeEntities)
		{
			System.out.println(e);
		}
	}
	
	public void getEmpByNameOrSalary()
	{
		List<EmployeeEntity> employeeEntities=repo.findByEmpNameOrSalary("Ajinkya", 23.00);
		
		for(EmployeeEntity e:employeeEntities)
		{
			System.out.println(e);
		}
	}
	
	public void getEmpBySalaryIsGreatherThanEqual()
	{
		List<EmployeeEntity> employeeEntities=repo.findBySalaryGreaterThanEqual(480.9);
		
		for(EmployeeEntity e:employeeEntities)
		{
			System.out.println(e);
		}
	}
	
	
	
}
