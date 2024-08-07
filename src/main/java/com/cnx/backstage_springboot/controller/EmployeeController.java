package com.cnx.backstage_springboot.controller;

import com.cnx.backstage_springboot.dto.EmployeeDTO;
import com.cnx.backstage_springboot.service.EmployeeService;
import com.cnx.backstage_springboot.utility.ResponseHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<Object> getAllEmployee(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) throws JsonProcessingException {
    return ResponseHandler.generateResponse(HttpStatus.OK, employeeService.getAllEmployee(name, page, size));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getEmployee(@PathVariable Integer id) throws JsonProcessingException {
    return ResponseHandler.generateResponse(HttpStatus.OK, employeeService.getEmployeeById(id));
  }

  @PostMapping
  public ResponseEntity<Object> saveEmployee(@RequestBody @Valid EmployeeDTO employeeDto) throws JsonProcessingException {
    return ResponseHandler.generateResponse(HttpStatus.CREATED, employeeService.saveNewEmployee(employeeDto));
  }

  @PatchMapping
  public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDTO employeeDto) throws JsonProcessingException {
    return ResponseHandler.generateResponse(HttpStatus.OK, employeeService.updateEmployee(employeeDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteEmployee(@PathVariable Integer id) {
    employeeService.deleteEmployee(id);
    return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT, "DELETED");
  }
}
