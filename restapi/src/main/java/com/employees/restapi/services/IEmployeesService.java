package com.employees.restapi.services;

import java.util.Collection;

import com.employees.restapi.models.Employee;

public interface IEmployeesService {

    Collection<Employee> listAll();

    Employee getById(Long id);

    Employee add(Employee employee);

    Employee update(Employee employee);

    Employee deleteById(Long id);
}