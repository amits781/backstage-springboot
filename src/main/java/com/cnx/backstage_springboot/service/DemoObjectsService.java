package com.cnx.backstage_springboot.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value = "placeholderObjects", url = "https://api.restful-api.dev")
public interface DemoObjectsService {
    @GetMapping("/objects")
    @CircuitBreaker(name = "objectsCB", fallbackMethod = "getDefaultObjects")
    String getObjects();
    
    @GetMapping("/objects2")
    @CircuitBreaker(name = "objects2CB", fallbackMethod = "getDefaultObjects")
    String getObjectsFallback();

    default public String getDefaultObjects(Throwable throwable) {
        return "This is fallback method, no objects can be fetched this time.";
    }

}
