package com.cnx.backstage_springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee implements Serializable {

  private static final long serialVersionUID = -8723761350263387124L;
  

  @Id
  @SequenceGenerator(name = "SequenceEmployeeId", sequenceName = "EMP_ID_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceEmployeeId")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Integer age;

  @Column(name = "department")
  private String department;

  
}
