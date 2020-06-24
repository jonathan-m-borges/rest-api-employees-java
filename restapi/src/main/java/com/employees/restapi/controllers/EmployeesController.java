package com.employees.restapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import com.employees.restapi.models.Employee;
import com.employees.restapi.services.IEmployeesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeesController {

    private IEmployeesService service;

    public EmployeesController(IEmployeesService service) {
        super();
        this.service = service;
    }

    @GetMapping(value = "/api/employees")
    public Collection<Employee> listAll() {
        return service.listAll();
    }

    // GET: api/Employees/5
    @GetMapping(value = "/api/employees/{id}")
    public Employee getById(@PathVariable("id") Long id) {
        var employee = service.getById(id);
        if (employee != null)
            return employee;
        return null;
        // TODO exception
    }

    // POST: api/Employees
    @PostMapping("/api/employees")
    public Employee add(@RequestBody Employee employee) {
        return service.add(employee);
    }

    @PutMapping("/api/employees/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return service.update(employee);
    }

    @DeleteMapping("/api/employees/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        return service.deleteById(id);
    }

}