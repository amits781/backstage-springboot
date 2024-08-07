package com.cnx.backstage_springboot.service.implementation;

import com.cnx.backstage_springboot.dao.EmployeeDao;
import com.cnx.backstage_springboot.dto.EmployeeDTO;
import com.cnx.backstage_springboot.entity.Employee;
import com.cnx.backstage_springboot.exception.NotFoundException;
import com.cnx.backstage_springboot.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

  @Autowired
  EmployeeDao employeeDao;

  @Autowired
  ObjectMapper objectMapper;

  @Override
  public EmployeeDTO getEmployeeById(Integer id) throws JsonProcessingException {
    Employee employeeEntity =
        employeeDao.getEmployeeById(id).orElseThrow(() -> new NotFoundException("Employee Id :" + id + " dose not exists."));
    return objectMapper.readValue(objectMapper.writeValueAsString(employeeEntity), EmployeeDTO.class);
  }

  @Override
  public Page<Employee> getAllEmployee(String nameFilter, Integer page, Integer size) throws JsonProcessingException {
    Pageable pageable = PageRequest.of(page, size);
    return nameFilter.isBlank() ? employeeDao.getAllEmployee(pageable) : employeeDao.findAllByName(nameFilter, pageable);
  }

  @Override
  public Integer saveNewEmployee(EmployeeDTO employeeRequestDTO) throws JsonProcessingException {

    Employee empEntity = objectMapper.readValue(objectMapper.writeValueAsString(employeeRequestDTO), Employee.class);
    empEntity = employeeDao.saveNewEmployee(empEntity);
    return empEntity.getId();
  }

  @Override
  public Integer updateEmployee(EmployeeDTO employeeRequestDTO) throws JsonProcessingException {
    employeeDao.getEmployeeById(employeeRequestDTO.getId())
        .orElseThrow(() -> new NotFoundException("Employee Id :" + employeeRequestDTO.getId() + " dose not exists."));
    Employee empEntity = objectMapper.readValue(objectMapper.writeValueAsString(employeeRequestDTO), Employee.class);
    empEntity = employeeDao.updateEmployee(empEntity);
    return empEntity.getId();
  }

  @Override
  public void deleteEmployee(Integer id) {
    employeeDao.deleteEmployee(id);
  }
}
