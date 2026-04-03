package com.exampleSpringMVC.Spring_RestApi.services;

import com.exampleSpringMVC.Spring_RestApi.DTO.EmployeeDTO;
import com.exampleSpringMVC.Spring_RestApi.configs.MapperConfig;
import com.exampleSpringMVC.Spring_RestApi.entity.EmployeeEntity;
import com.exampleSpringMVC.Spring_RestApi.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository ;
    private final ModelMapper mappermapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mappermapper) {
        this.employeeRepository = employeeRepository;
        this.mappermapper = mappermapper;
    }

    public EmployeeDTO getEmployee(Long id) {
        EmployeeEntity employee_entity = employeeRepository.findById(id).orElse(null) ;
        return mappermapper.map(employee_entity , EmployeeDTO.class);
    }

    public List<EmployeeEntity> getallEmployees() {
        return employeeRepository.findAll() ;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee) ;
    }
}
