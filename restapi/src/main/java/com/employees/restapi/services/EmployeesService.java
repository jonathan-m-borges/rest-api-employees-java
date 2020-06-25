package com.employees.restapi.services;

import java.util.Collection;
import com.employees.restapi.models.Employee;
import com.employees.restapi.repositories.IEmployeesRepository;

import org.springframework.stereotype.Component;

@Component
public class EmployeesService implements IEmployeesService {
    private IEmployeesRepository repository;
    public EmployeesService(IEmployeesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Employee> listAll() {
        // TODO regras de negócio, se tiver
        return repository.listAll();
    }

    @Override
    public Employee getById(long id) {
        // TODO regras de negócio, se tiver
        return repository.getById(id);
    }

    @Override
    public Employee add(Employee employee) {
        // TODO regras de negócio, se tiver
        // Exemplo: enviar email para o RH com os dados do empregado adicionado
        return repository.add(employee);
    }

    @Override
    public Employee update(Employee employee) {
        // TODO regras de negócio, se tiver
        return repository.update(employee);
    }

    @Override
    public Employee deleteById(long id) {
        // TODO regras de negócio, se tiver
        return repository.deleteById(id);
    }
}