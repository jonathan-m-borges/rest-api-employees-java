package com.employees.restapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import com.employees.restapi.models.Employee;
import com.employees.restapi.services.IEmployeesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeesController {

    private IEmployeesService service;

    public EmployeesController(IEmployeesService service) {
        super();
        this.service = service;
    }

    @GetMapping(value = "/api/employees")
    public Collection<Employee> getAll() {
        return service.listAll();
    }

    // GET: api/Employees/5
    @GetMapping(value = "/api/employees/{id}")
    public Employee Get(@PathVariable("id") Long id) {
        var employee = service.getById(id);
        if (employee != null)
            return employee;
        return null;
        //TODO exception
    }

    //// POST: api/Employees
    // [HttpPost]
    // public Employee Post([FromBody] Employee employee)
    // {
    // service.Add(employee);
    // return employee;
    // }
    //
    //// PUT: api/Employees/5
    // [HttpPut("{id}")]
    // public ActionResult Put(int id, [FromBody] Employee employee)
    // {
    // var employeeFinded = service.GetById(id);
    // if (employeeFinded == null)
    // return NotFound();
    //
    // employee.Id = id;
    // service.Update(employee);
    //
    // return Ok(employee);
    // }
    //
    //// DELETE: api/Employees/5
    // [HttpDelete("{id}")]
    // public ActionResult Delete(int id)
    // {
    // var employeeFinded = service.GetById(id);
    // if (employeeFinded == null)
    // return NotFound();
    //
    // service.DeleteById(id);
    // return Ok();
    // }

}