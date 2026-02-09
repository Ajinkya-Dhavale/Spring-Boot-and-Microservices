package com.ajinkya.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ajinkya.entity.EmployeeEntity;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Integer>{
	public List<EmployeeEntity> findByEmpName(String name);
	
	public List<EmployeeEntity> findByEmpNameAndSalary(String name, Double salary);
	
	public List<EmployeeEntity> findByEmpNameOrSalary(String name, Double salary);
	
	public List<EmployeeEntity> findBySalaryGreaterThanEqual(Double salary);
	
//	write HQL Queries
	@Query("FROM EmployeeEntity")
	public List<EmployeeEntity> getAllEmp();

	
//	write sql queries
	@Query(value = "select * from emp",nativeQuery = true)
	public List<EmployeeEntity> getAllEmpSql();

//	insert the record
	@Modifying
    @Transactional
    @Query(value = "INSERT INTO emp (emp_id, emp_name) VALUES (:empId, :empName)", nativeQuery = true)
    void insertEmployee(Integer empId, String empName);
	
//	update the record
	@Modifying
	@Transactional
	@Query("UPDATE EmployeeEntity e SET e.salary = :salary WHERE e.empId = :empId")
	void updateEmployee(Integer empId,Double salary);

}

