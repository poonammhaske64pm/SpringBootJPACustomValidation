package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // signup
    public Employee signUp(Employee employee){
        return employeeRepository.save(employee);
    }

    // signin
    public boolean signIn(String emailId, String emailPassword){

        boolean flag = false;
        for(Employee employee : employeeRepository.findAll()){
            if(employee.getEmailId().equals(emailId) && employee.getEmailPassword().equals(emailPassword)){
                flag = true;
            }
        }
        return flag;
    }

    //getdatabyid
    public Optional<Employee> getDataById(int id){
        return employeeRepository.findById(id);
    }

    // getalldata
    public List<Employee> getAllData(){
        return employeeRepository.findAll();
    }

    // updatedatabyid
    public Employee updateById(Employee employee){
        return employeeRepository.save(employee);
    }

    // deletebyid
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }
}
