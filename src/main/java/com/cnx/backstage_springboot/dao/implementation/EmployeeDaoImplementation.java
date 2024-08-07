package com.cnx.backstage_springboot.dao.implementation;

import com.cnx.backstage_springboot.dao.EmployeeDao;
import com.cnx.backstage_springboot.entity.Employee;
import com.cnx.backstage_springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeDaoImplementation implements EmployeeDao {

  @Autowired
  EmployeeRepository repository;

  @Override
  public Optional<Employee> getEmployeeById(Integer id) {
    return repository.findById(id);
  }

  @Override
  public Page<Employee> getAllEmployee(Pageable pageable) {
    return repository.findAll(pageable);
  }


  @Override
  public Page<Employee> findAllByName(String name, Pageable pageable) {
    return repository.findByNameContaining(name, pageable);
  }

  @Override
  public Employee saveNewEmployee(Employee entity) {
    return repository.save(entity);
  }

  @Override
  public Employee updateEmployee(Employee entity) {
    return repository.save(entity);
  }

  @Override
  public void deleteEmployee(Integer id) {
      repository.deleteById(id);
  }
}
