package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Employee;
import com.example.springdatajpa.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // READ - Get all employees
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // READ - Get employee by ID
    public Employee getEmployeeById(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    // UPDATE
    public Employee updateEmployee(int id, Employee employee) {

        Employee existingEmployee =
                repository.findById(id).orElse(null);

        if (existingEmployee == null) {
            return null;
        }

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return repository.save(existingEmployee);
    }

    // DELETE
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}