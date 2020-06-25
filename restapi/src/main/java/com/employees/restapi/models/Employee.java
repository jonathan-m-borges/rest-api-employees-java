package com.employees.restapi.models;

import lombok.Data;

@Data
public class Employee {
    private long id;
    private String name;
    private Float salary;
    private Integer age;
    private String ProfileImage;
}
