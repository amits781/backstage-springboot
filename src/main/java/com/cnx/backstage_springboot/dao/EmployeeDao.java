package com.cnx.backstage_springboot.dao;

import com.cnx.backstage_springboot.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeDao {

  //Get Operations
  public Optional<Employee> getEmployeeById(Integer id);
  public Page<Employee> getAllEmployee(Pageable pageable);
  public Page<Employee> findAllByName(String name, Pageable pageable);

  //Create Operation
  public Employee saveNewEmployee(Employee entity);

  //Update Operation
  public Employee updateEmployee(Employee entity);

  //Delete Operation
  public void deleteEmployee(Integer id);

}
