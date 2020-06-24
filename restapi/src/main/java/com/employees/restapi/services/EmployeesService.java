package com.employees.restapi.services;

import java.util.Collection;

import com.employees.restapi.models.Employee;
import com.employees.restapi.repositories.IEmployeesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeesService implements IEmployeesService {

    private IEmployeesRepository repository;

    @Autowired
    public EmployeesService(@Qualifier("employeesRepositoryMemory") IEmployeesRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Collection<Employee> listAll() {
        // TODO regras de negócio, se tiver
        // Exemplo: enviar email para o RH com os dados do empregado adicionado
        return repository.listAll();
    }

    @Override
    public Employee getById(Long id) {
        // TODO regras de negócio, se tiver
        return repository.getById(id);
    }

    @Override
    public Employee add(Employee employee) {
        // TODO regras de negócio, se tiver
        return repository.add(employee);
    }

    @Override
    public Employee update(Employee employee) {
        // TODO regras de negócio, se tiver
        return repository.update(employee);
    }

    @Override
    public Employee deleteById(Long id) {
        // TODO regras de negócio, se tiver
        return repository.deleteById(id);
    }
}