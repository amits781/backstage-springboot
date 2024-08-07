package com.cnx.backstage_springboot.service;

import com.cnx.backstage_springboot.dto.EmployeeDTO;
import com.cnx.backstage_springboot.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;


public interface EmployeeService {

  // Get Operations
  public EmployeeDTO getEmployeeById(Integer id) throws JsonProcessingException;

  public Page<Employee> getAllEmployee(String nameFilter, Integer page, Integer size) throws JsonProcessingException;

  // Create Operation
  public Integer saveNewEmployee(EmployeeDTO employeeRequestDTO) throws JsonProcessingException;

  // Update Operation
  public Integer updateEmployee(EmployeeDTO employeeRequestDTO) throws JsonProcessingException;

  // Delete Operation
  public void deleteEmployee(Integer id);
}
