package com.employees.restapi.repositories;
import java.util.Collection;
import java.util.HashMap;
import com.employees.restapi.models.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeesRepositoryMemory implements IEmployeesRepository {

    private static Long idCount = 0L;
    private static HashMap<Long, Employee> map = new HashMap<Long, Employee>();

    @Override
    public Collection<Employee> listAll() {
        return map.values();
    }

    @Override
    public Employee getById(long id) {
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
    public Employee deleteById(long id) {
        if (!map.containsKey(id))
            return null;
        var employee = map.get(id);
        map.remove(id);
        return employee;
    }
}