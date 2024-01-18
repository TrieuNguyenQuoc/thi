package com.example.test4.service;


import com.example.test4.model.Employee;

import java.util.List;

public interface IEmplService extends IGenerateService<Employee> {
    List<Employee> getAllUsersOrderByAgeAsc();
}
