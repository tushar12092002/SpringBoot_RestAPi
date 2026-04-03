package com.exampleSpringMVC.Spring_RestApi.controller;

import com.exampleSpringMVC.Spring_RestApi.DTO.EmployeeDTO;
import com.exampleSpringMVC.Spring_RestApi.entity.EmployeeEntity;
import com.exampleSpringMVC.Spring_RestApi.services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping()
    public String getmysecretmessage(){
        return "Hello World ! ...." ;
    }

    //neither repository or entity should be in controller
    private final EmployeeService employeeservice ;

    public EmployeeController(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }

    //jackson library is converting java object into json
    @GetMapping(path = "/{Id}")
    public EmployeeDTO getEmployee(@PathVariable(name = "Id") Long id){
        return employeeservice.getEmployee(id) ;
    }

    @GetMapping(path = "/employees")
    public List<EmployeeEntity> getallEmployees(@RequestParam(required = false) Integer age ,
                                   @RequestParam(required = false) String SortBy){
        return employeeservice.getallEmployees() ;
    }

    @PostMapping()
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeservice.createNewEmployee(inputEmployee)  ;
    }

    //passing data through request body is left
}
