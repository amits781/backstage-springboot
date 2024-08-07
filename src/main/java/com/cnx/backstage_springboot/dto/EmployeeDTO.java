package com.cnx.backstage_springboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

  private Integer id;

  @NotBlank(message = "Employee name cannot be empty")
  private String name;

  private Integer age;

  @NotBlank(message = "Employee department cannot be empty")
  private String department;

  
}
