package com.example.test4.service.impl;


import com.example.test4.model.Employee;
import com.example.test4.repository.EmployeeRepository;
import com.example.test4.service.IEmplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmplService implements IEmplService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllUsersOrderByAgeAsc() {
        return employeeRepository.findAllOrderByAgeAsc() ;
    }
}
