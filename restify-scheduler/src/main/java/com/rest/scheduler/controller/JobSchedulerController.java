package com.rest.scheduler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//https://www.tutorialsbuddy.com/quartz-with-spring-boot-and-mysql-example

@RestController
public class JobSchedulerController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity<String> checkHealthStatus(){
        return new ResponseEntity<String>("OK", HttpStatus.ACCEPTED);
    }
}
