package com.employees.restapi.repositories;

import java.util.HashMap;
import java.util.Collection;

import com.employees.restapi.models.Employee;

import org.springframework.stereotype.Component;

@Component("employeesRepositoryMemory")
public class EmployeesRepositoryMemory implements IEmployeesRepository {
    private static Long idCount = 0L;
    private HashMap<Long, Employee> map = new HashMap<Long, Employee>();

    @Override
    public Collection<Employee> listAll() {
        return map.values();
    }

    @Override
    public Employee getById(Long id) {
        if (map.containsKey(id))
            return map.get(id);
        else
            return null;
    }

    @Override
    public Employee add(Employee employee) {
        idCount++;
        employee.setId(idCount);
        map.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        if (!map.containsKey(employee.getId()))
            return null;
        map.replace(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee deleteById(Long id) {
        if (!map.containsKey(id))
            return null;
        var employee = map.get(id);
        map.remove(id);
        return employee;
    }

}