package com.example.test4.repository;


import com.example.test4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT u FROM Employee u ORDER BY u.age ASC")
    List<Employee> findAllOrderByAgeAsc();
}
