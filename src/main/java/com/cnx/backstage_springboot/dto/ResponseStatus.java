package com.cnx.backstage_springboot.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatus {

  private int status;
  private Object payload;

  
}
