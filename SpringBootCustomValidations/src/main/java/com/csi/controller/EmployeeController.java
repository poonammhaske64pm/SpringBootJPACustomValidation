package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // signup
    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee){
        log.info("############################################## sign up for employee");
        return ResponseEntity.ok(employeeService.signUp(employee));
    }

    // signin
    @GetMapping("/signin/{emailId}/{emailPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String emailId, @PathVariable String emailPassword){
        log.info("############################################## sign in for employee");
        return ResponseEntity.ok(employeeService.signIn(emailId, emailPassword));
    }

    //getdatabyid
    @GetMapping("/getdatabyid/{id}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int id){
        log.info("############################################## get employee data by id");
        return ResponseEntity.ok(employeeService.getDataById(id));
    }

    // getalldata
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        log.info("############################################## get all employee data");
        return ResponseEntity.ok(employeeService.getAllData());
    }

    // updatedatabyid
    @PutMapping("/updatedatabyid/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable int id, @Valid @RequestBody Employee employee){
        log.info("############################################## update employee data by id");

        Employee employee1 = employeeService.getDataById(id).orElseThrow(()-> new RecordNotFoundException("EMPLOYEE ID NOT FOUND"));

        employee1.setSalary(employee.getSalary());
        employee1.setEmailId(employee.getEmailId());
        employee1.setName(employee.getName());
        employee1.setEmailPassword(employee.getEmailPassword());

        return new ResponseEntity<>(employeeService.updateById(employee1), HttpStatus.CREATED);
    }

    //deletebyid
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        log.info("############################################## delete employee data by id");
        employeeService.deleteById(id);
        return ResponseEntity.ok("DATA DELETED");
    }
}
