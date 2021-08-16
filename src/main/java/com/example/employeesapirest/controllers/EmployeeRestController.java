package com.example.employeesapirest.controllers;

import com.example.employeesapirest.models.entity.Employee;
import com.example.employeesapirest.models.services.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    private final Logger log = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping("/employees/page/{page}")
    public Page<Employee> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return employeeService.findAll(pageable);
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/employees")
    public ResponseEntity<?> create(@Valid @RequestBody Employee employee, BindingResult result) {

        Employee employeeNew = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "The field '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            employeeNew = employeeService.save(employee);
        } catch (DataAccessException e) {
            response.put("message", "Failed to insert into database");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "The employee has been created successfully!");
        response.put("employee", employeeNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
