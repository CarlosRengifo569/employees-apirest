package com.example.employeesapirest.models.services;

import com.example.employeesapirest.models.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    public Page<Employee> findAll(Pageable pageable);

    public Employee save(Employee employee);

    public List<Employee> getAll();

}
