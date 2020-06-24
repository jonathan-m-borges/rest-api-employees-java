package com.employees.restapi.repositories;

import java.util.Collection;

import com.employees.restapi.models.Employee;

public interface IEmployeesRepository {

    Collection<Employee> listAll();

    Employee getById(Long id);

    Employee add(Employee employee);

    Employee update(Employee employee);

    Employee deleteById(Long id);

}