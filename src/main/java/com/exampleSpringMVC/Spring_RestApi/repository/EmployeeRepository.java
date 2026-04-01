package com.exampleSpringMVC.Spring_RestApi.repository;

import com.exampleSpringMVC.Spring_RestApi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
    List<EmployeeEntity> FindByName(String name) ;

}
