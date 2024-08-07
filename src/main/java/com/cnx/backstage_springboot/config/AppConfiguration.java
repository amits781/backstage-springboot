package com.cnx.backstage_springboot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import java.text.SimpleDateFormat;

@Configuration
public class AppConfiguration {

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
//     Customize your ObjectMapper here
//    mapper.registerModule(new JavaTimeModule()); // Support for Java 8 Date/Time API
//    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    return mapper;
  }

}
