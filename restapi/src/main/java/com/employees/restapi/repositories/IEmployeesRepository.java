package com.employees.restapi.repositories;

import java.util.Collection;
import com.employees.restapi.models.Employee;

public interface IEmployeesRepository {
    public Collection<Employee> listAll();

    public Employee getById(long id);

    public Employee add(Employee employee);

    public Employee update(Employee employee);

    public Employee deleteById(long id);
}