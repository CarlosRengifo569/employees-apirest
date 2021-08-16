package com.example.employeesapirest.models.services;

import com.example.employeesapirest.models.dao.IEmployeeDao;
import com.example.employeesapirest.models.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public Page<Employee> findAll(Pageable pageable) {
        return employeeDao.findAll(pageable);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return  employeeDao.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }
}
