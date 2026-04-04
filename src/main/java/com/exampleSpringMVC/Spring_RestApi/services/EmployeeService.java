package com.exampleSpringMVC.Spring_RestApi.services;

import com.exampleSpringMVC.Spring_RestApi.DTO.EmployeeDTO;
import com.exampleSpringMVC.Spring_RestApi.configs.MapperConfig;
import com.exampleSpringMVC.Spring_RestApi.entity.EmployeeEntity;
import com.exampleSpringMVC.Spring_RestApi.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<EmployeeDTO> getallEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(employeeEntity -> mappermapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }



    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {

        // DTO -> Entity
        EmployeeEntity employeeEntity = mappermapper.map(inputEmployee, EmployeeEntity.class);

        // Save entity
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);

        // Entity -> DTO
        return mappermapper.map(savedEntity, EmployeeDTO.class);
    }
}
