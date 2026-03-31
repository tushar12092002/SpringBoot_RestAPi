package com.exampleSpringMVC.Spring_RestApi.controller;

import com.exampleSpringMVC.Spring_RestApi.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping()
    public String getmysecretmessage(){
        return "Hello World ! ...." ;
    }

    //jackson library is converting java object into json
    @GetMapping(path = "/{Id}")
    public EmployeeDTO getEmployee(@PathVariable(name = "Id") Long id){
        return new EmployeeDTO(id ,"Tushar" ,"tushar@gmail.com" ,12, LocalDate.of(2026,9,12));
    }

    @GetMapping(path = "/employees")
    public String  getallEmployees(@RequestParam(required = false) Integer age ,
                                   @RequestParam(required = false) String SortBy){
        return "Hi " + age + SortBy ;
    }

    @PostMapping()
    public String getPostEmployee(){
        return "hello from post" ;
    }

    //passing data through request body is left
}
