package com.example.employeesapirest.models.entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_employee")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "function", nullable = false)
    private String function;

    @Column(name = "boss", nullable = false)
    private Long bossId;

    public Employee(Long id, String fullName, String function, Long bossId) {
        this.id = id;
        this.fullName = fullName;
        this.function = function;
        this.bossId = bossId;
    }

    public Employee(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Long getBossId() {
        return bossId;
    }

    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }
}
