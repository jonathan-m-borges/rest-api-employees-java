package com.employees.restapi.controllers;

import java.util.Collection;

import com.employees.restapi.models.Employee;
import com.employees.restapi.models.ErrorEntity;
import com.employees.restapi.services.IEmployeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {

    private IEmployeesService service;

    @Autowired
    public EmployeesController(IEmployeesService service) {
        this.service = service;
    }

    // GET /api/employees - retornar a lista de employees
    @RequestMapping(value = "/api/employees", method = RequestMethod.GET)
    public ResponseEntity<Collection<Employee>> listAll() {
        Collection<Employee> list = service.listAll();
        return new ResponseEntity<Collection<Employee>>(list, HttpStatus.OK);
    }

    // GET /api/employees/1 - retorna employee com o id 1
    @RequestMapping(value = "/api/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> buscar(@PathVariable("id") long id) {
        Employee employee = service.getById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // POST /api/employees - cria um novo employee
    @RequestMapping(value = "/api/employees", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> criar(@RequestBody Employee employee) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (employee.getName() == null || employee.getName().isEmpty()) {
            ErrorEntity error = new ErrorEntity("The name field is required!");
            return new ResponseEntity<ErrorEntity>(error, HttpStatus.BAD_REQUEST);
        }
        Employee result = service.add(employee);
        return new ResponseEntity<Employee>(result, HttpStatus.OK);
    }

    // PUT /api/employees - atualiza employee com id 1
    @RequestMapping(value = "/api/employees/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<?> atualizar(@RequestBody Employee employee, @PathVariable("id") long id) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (employee.getName() == null || employee.getName().isEmpty()) {
            ErrorEntity error = new ErrorEntity("The name field is required!");
            return new ResponseEntity<ErrorEntity>(error, HttpStatus.BAD_REQUEST);
        }
        employee.setId(id);
        Employee result = service.update(employee);
        if (result == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Employee>(result, HttpStatus.OK);
    }

    // DELETE /api/employees/1 - deleta employee com id 1
    @RequestMapping(value = "/api/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deletar(@PathVariable("id") int id) {
        Employee employee = service.deleteById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
}