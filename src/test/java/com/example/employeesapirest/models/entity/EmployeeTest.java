package com.example.employeesapirest.models.entity;

import com.example.employeesapirest.models.dao.IEmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeTest {

    @Autowired
    private IEmployeeDao employeeService;

    @Test
    public void testCreateEmpoloyee() {
        Employee employee1 = new Employee(123456L, "Fabio Rengifo", "Analist", 12345L);
        Employee employee2 = new Employee(123456L, "Fabio Rengifo", "Analist", null);
        employeeService.save(employee1);
        employeeService.save(employee2);
        employeeService.flush();
    }
}