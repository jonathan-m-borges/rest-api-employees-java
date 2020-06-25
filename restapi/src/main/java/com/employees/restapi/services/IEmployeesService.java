package com.employees.restapi.services;

import java.util.Collection;

import com.employees.restapi.models.Employee;

public interface IEmployeesService {
    public Collection<Employee> listAll();

    public Employee getById(long id);

    public Employee add(Employee employee);

    public Employee update(Employee employee);

    public Employee deleteById(long id);
}