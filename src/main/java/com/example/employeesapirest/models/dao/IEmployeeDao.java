package com.example.employeesapirest.models.dao;

import com.example.employeesapirest.models.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee, Long> {

}
