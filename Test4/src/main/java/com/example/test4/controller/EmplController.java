package com.example.test4.controller;


import com.example.test4.model.Employee;
import com.example.test4.service.impl.EmplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmplController {
    @Autowired
    private EmplService emplService;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> showEmployee(){
        return new ResponseEntity<>(emplService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<?> creatCity(@RequestBody Employee employee){
        emplService.save(employee);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Employee> find = emplService.findById(id);
        return new ResponseEntity<>(find,HttpStatus.OK);
    }

    @GetMapping("/sortedByAge")
    public List<Employee> getUsersSortedByAge() {
        return emplService.getAllUsersOrderByAgeAsc();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee,@PathVariable Long id) {
        Optional<Employee> city1 = this.emplService.findById(id);
        if (!city1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setId(city1.get().getId());
        employee.setMaEmployee(city1.get().getMaEmployee());
        employee.setNameEmployee(city1.get().getNameEmployee());
        employee.setMoney(city1.get().getMoney());
        employee.setAge(city1.get().getAge());
        employee.setPhong(city1.get().getPhong());

        emplService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        Optional<Employee> city = emplService.findById(id);
        if (city.isPresent()){
            emplService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
