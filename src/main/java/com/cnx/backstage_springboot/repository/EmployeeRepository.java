package com.cnx.backstage_springboot.repository;

import com.cnx.backstage_springboot.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  Page<Employee> findByNameContaining(String name, Pageable pageable);
}
