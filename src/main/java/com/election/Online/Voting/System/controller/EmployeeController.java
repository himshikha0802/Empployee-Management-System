package com.election.Online.Voting.System.controller;

import com.election.Online.Voting.System.dto.EmployeeUpdateDto;
import com.election.Online.Voting.System.dto.UserUpdateDto;
import com.election.Online.Voting.System.model.Employee;
import com.election.Online.Voting.System.model.User;
import com.election.Online.Voting.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){return employeeService.getAllEmployees();}

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @PostMapping
    public  Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @PutMapping //to update
    public Employee updateEmployee(@RequestBody @Valid EmployeeUpdateDto employee){
        //  return userService.updateUser(user);

        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return updatedEmployee;

    }

    @DeleteMapping
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }
}

