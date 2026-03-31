package com.exampleSpringMVC.Spring_RestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employee")
    public String getmysecretmessage(){
        return "Hello World ! ...." ;
    }
}
