package com.exampleSpringMVC.Spring_RestApi.controller;

import com.exampleSpringMVC.Spring_RestApi.DTO.EmployeeDTO;
import com.exampleSpringMVC.Spring_RestApi.entity.EmployeeEntity;
import com.exampleSpringMVC.Spring_RestApi.repository.EmployeeRepository;
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

    //neither repository or entity should be in controller
    private final EmployeeRepository employeeRepository ;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    //jackson library is converting java object into json
    @GetMapping(path = "/{Id}")
    public EmployeeEntity getEmployee(@PathVariable(name = "Id") Long id){
        return employeeRepository.findById(id).orElse(null) ;
    }

    @GetMapping(path = "/employees")
    public List<EmployeeEntity> getallEmployees(@RequestParam(required = false) Integer age ,
                                   @RequestParam(required = false) String SortBy){
        return employeeRepository.findAll() ;
    }

    @PostMapping()
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee)  ;
    }

    //passing data through request body is left
}
